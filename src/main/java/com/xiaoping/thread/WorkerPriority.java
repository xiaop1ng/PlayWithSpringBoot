package com.xiaoping.thread;

public class WorkerPriority {

    public static void main(String[] args) {
        // 测试线程优先级

        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                boolean flag = false;

                for (int i = 0; i < 100000000; i++) {
                    flag = true;
                }

                if (flag) {
                    System.out.println(this.getName() + " finished work!");
                }
            }
        };

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                boolean flag = false;

                for (int i = 0; i < 100000000; i++) {
                    flag = true;
                }

                if (flag) {
                    System.out.println(this.getName() + " finished work!");
                }
            }
        };

        Thread t3 = new Thread("t3") {
            @Override
            public void run() {
                boolean flag = false;

                for (int i = 0; i < 100000000; i++) {
                    flag = true;
                }

                if (flag) {
                    System.out.println(this.getName() + " finished work!");
                }
            }
        };

        t1.setPriority(Thread.MIN_PRIORITY); // 1
        t2.setPriority(Thread.NORM_PRIORITY); // 5
        t3.setPriority(Thread.MAX_PRIORITY); // 10

        t1.start();
        t2.start();
        t3.start();
        // t3 finish work!
        // t2 finish work!
        // t1 finish work!
    }

}
