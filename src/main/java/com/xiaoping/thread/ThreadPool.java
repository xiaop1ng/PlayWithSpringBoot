package com.xiaoping.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPool {

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + " - " + Thread.currentThread().getId() );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        ExecutorService es = Executors.newFixedThreadPool(10); // 指定线程池大小
//        ExecutorService es = Executors.newCachedThreadPool();

        for (int i = 0; i < 30; i++) {
//            es.execute(task);
            es.submit(task);
        }
    }
}
