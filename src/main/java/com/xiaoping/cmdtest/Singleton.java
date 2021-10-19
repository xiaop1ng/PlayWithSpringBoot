package com.xiaoping.cmdtest;

/**
 * 枚举单例 线程安全
 */
public enum Singleton {

    INSTANCE;
    public void sayHello() {
        System.out.println("Hello World!");
    }

}
