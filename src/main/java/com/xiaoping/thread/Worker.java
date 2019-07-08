package com.xiaoping.thread;

public class Worker implements Runnable{


    private static Worker w1;
    private static Object obj;
    public static void main(String[] args) {
        obj = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("invoke by " + this.getName() );
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                super.run();

                while (true) {
                    try {
                        this.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.getName() + ": invoke by runable" + obj.hashCode());

                }
            }
        };

        w1 = new Worker();

        Thread t4 = new Thread(w1);

        t1.start();
        t2.start();


        t4.start();


        // 这里执行 start()，会开启一个新线程，然后执行 run()
        // 需要注意的是 run() 可以直接被访问到，但是直接调用他只会在当前线程中串行执行 run() 中的代码。
    }


    @Override
    public void run() {
        System.out.println("invoke by worker");
    }
}
