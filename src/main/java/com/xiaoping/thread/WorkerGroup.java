package com.xiaoping.thread;

public class WorkerGroup {

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("printGroup");
        Thread t1 = new Thread(tg, "thread1") {
            @Override
            public void run() {
                    try {
                        System.out.println(System.currentTimeMillis() + " - t1 start");
                        this.sleep(2000); // sleep 不会释放任何资源

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis() + " - t1 end");

            }
        };

        Thread t2 = new Thread(tg, "thread2") {
            @Override
            public void run() {
                    try {
                        System.out.println(System.currentTimeMillis() + " - t2 start");
                        this.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis() + " - t2 end");


            }
        };

        t1.start();
        t2.start();
        System.out.println(tg.activeCount());
        tg.list();

        // t1 start -> t2 start -> t2 end -> t1 end

    }
}
