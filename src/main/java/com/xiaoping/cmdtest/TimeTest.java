package com.xiaoping.cmdtest;

import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        Date expireTime = new Date();
        System.out.println(expireTime);
        expireTime.setTime(expireTime.getTime() + 1000*60*30); // 半小时
        System.out.println(expireTime);
    }
}
