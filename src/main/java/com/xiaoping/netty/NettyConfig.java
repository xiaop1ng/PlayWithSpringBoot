package com.xiaoping.netty;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NettyConfig {

    // 存储所有连接的 channel
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static String WS_HOST;

    public static int WS_PORT;

    // spring boot 不允许/不支持把值注入到静态变量中 所以采用 setter 的方式注入
    @Value("${netty.host}")
    public void setWS_HOST(String host) {
        this.WS_HOST = host;
    }

    @Value("${netty.port}")
    public void setWS_PORT(int port) {
        this.WS_PORT = port;
    }

}
