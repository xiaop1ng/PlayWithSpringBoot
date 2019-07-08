package com.xiaoping.thread;

public class WorkerWaitNotify {

    private static Object obj = new Object();
    public static void main(String[] args) {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (obj) { // synchronized 申请了 obj 对象的锁

                    try {
                        System.out.println(System.currentTimeMillis() + " - t1 start");
                        this.sleep(2000); // sleep 不会释放任何资源

                        obj.wait(); // wait 会释放目标对象的锁

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(System.currentTimeMillis() + " - t1 end");

                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        System.out.println(System.currentTimeMillis() + " - t2 start");
                        obj.notify(); // t1 在得到通知后会在 t2 执行完毕后继续执行
                        this.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis() + " - t2 end");

                }

            }
        };

        t1.start();
        t2.start();
        // t1 start -> t2 start -> t2 end -> t1 end


    }
}
