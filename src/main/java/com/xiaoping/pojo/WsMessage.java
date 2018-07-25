package com.xiaoping.pojo;

public class WsMessage {

    private int t; // 消息类型
    private String n; // 用户名称
    // TODO: 预留房间ID
    private long room_id; // 房间 ID
    private String body; // 消息主体
    private int err; //错误码

    @Override
    public String toString() {
        return "WsMessage{" +
                "t=" + t +
                ", n='" + n + '\'' +
                ", room_id=" + room_id +
                ", body='" + body + '\'' +
                ", err=" + err +
                '}';
    }

    public WsMessage(int t, String n, int err) {
        this.t = t;
        this.n = n;
        this.err = err;
    }

    public WsMessage(int t, String n) {
        this.t = t;
        this.n = n;
        this.err = 0;
    }

    public WsMessage(int t, String n, String body, int err) {
        this.t = t;
        this.n = n;
        this.body = body;
        this.err = err;
    }

    public WsMessage(int t, String n, String body) {
        this.t = t;
        this.n = n;
        this.body = body;
        this.err = 0;
    }

    public int getErr() {
        return this.err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public int getT() {
        return this.t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public String getN() {
        return this.n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(long room_id) {
        this.room_id = room_id;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
