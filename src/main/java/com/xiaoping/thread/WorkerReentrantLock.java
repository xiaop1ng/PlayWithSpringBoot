package com.xiaoping.thread;

import java.util.concurrent.locks.ReentrantLock;

public class WorkerReentrantLock {

    public static int i = 0;

    static class RunWithLock implements Runnable {

        private ReentrantLock lock = new ReentrantLock();
        @Override
        public void run() {

            for (int j = 0; j < 1000000; j++) {
                lock.lock();
                try{
                    i++;
                }finally {
                    lock.unlock();
                }

            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        RunWithLock runWithLock = new RunWithLock();
        Thread t1 = new Thread(runWithLock);
        Thread t2 = new Thread(runWithLock);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(i);

    }
}
