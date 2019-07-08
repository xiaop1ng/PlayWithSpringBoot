package com.xiaoping.thread;

public class WorkerDaemon {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("I'm alive!");
                }
            }
        };

        t1.setDaemon(true); // 将线程设置为守护线程

        t1.start();

        try {
            Thread.sleep(3000); // 3s 后 Main 程序执行完毕，由于 t1 是一个守护线程，所以这个时候 Java 虚拟机就退出了
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
