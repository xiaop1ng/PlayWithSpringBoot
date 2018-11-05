package com.xiaoping.thread;

public class WorkerJoin {

    private static int i;

    private static volatile int volatileVal; // 被 volatile 关键字修饰的变量等于告诉了虚拟机，这个变量极有可能会被某些程序或者线程修改

    static class Worker extends Thread{

        @Override
        public void run() {
            for (int j = 0; j < 1000000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker w = new Worker();
        w.setName("countWorker");

        // w.start();
        // System.out.println(i); // 0

        w.start();
        w.join(); // join 方法会在这儿等待 w 工作完成后继续往下执行。join(long millis) 则表示过了最大忍耐时间后继续往下执行
        System.out.println(i); // 1000000


    }
}
