package com.xiaoping.thread;

public class WorkerSafe {

    private static volatile int i;
    private static WorkerSafe instance = new WorkerSafe();

    public synchronized static void  incr() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread("counter1") {
            @Override
            public void run() {

                for (int j = 0; j < 1000000; j++) {
                    incr();
                }

            }
        };

        Thread t2 = new Thread("counter2") {
            @Override
            public void run() {
                for (int j = 0; j < 1000000; j++) {
                    incr();
                }
            }
        };

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i: " + i); // i: 1650466 not safe; 使用 synchronized 之后的结果 2000000
    }
}
