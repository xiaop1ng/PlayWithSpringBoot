package com.xiaoping.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;

import java.util.Date;

public class WebSocketHandler extends SimpleChannelInboundHandler<Object> {

    private WebSocketServerHandshaker handshaker;

    // onmsg
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof FullHttpRequest){
            handHttpRequest(ctx, (FullHttpRequest) msg);
        }else if(msg instanceof WebSocketFrame){
            handWsMessage(ctx, (WebSocketFrame) msg);
        }
    }

    // onopen
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.group.add(ctx.channel());
    }

    // onclose
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.group.remove(ctx.channel());
    }

    // onmsgover
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    // onerror
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private void handWsMessage(ChannelHandlerContext ctx, WebSocketFrame msg) {
        if(msg instanceof CloseWebSocketFrame){
            // 关闭指令
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) msg.retain());
        }

        if(msg instanceof PingWebSocketFrame) {
            // ping 消息
            ctx.channel().write(new PongWebSocketFrame(msg.content().retain()));
        }else if(msg instanceof TextWebSocketFrame){
            TextWebSocketFrame message = (TextWebSocketFrame) msg;
            // 文本消息
            System.out.println("收到消息" + message.text());
            System.out.println(NettyConfig.group.size());
            NettyConfig.group.writeAndFlush(new TextWebSocketFrame(new Date().toString()));
        }
    }

    private void handHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        if(!req.decoderResult().isSuccess() || !("websocket".equals(req.headers().get("Upgrade")))){
            sendHttpResponse(ctx, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        WebSocketServerHandshakerFactory factory = new WebSocketServerHandshakerFactory("ws://" + NettyConfig.WS_HOST + NettyConfig.WS_PORT, null, false);
        handshaker = factory.newHandshaker(req);
        if(handshaker == null){
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else {
            handshaker.handshake(ctx.channel(), req);
        }
    }

    private void sendHttpResponse(ChannelHandlerContext ctx,  DefaultFullHttpResponse res) {
        if(res.status().code() != 200){
            ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
        }
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if(res.status().code() != 200){
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }
}
