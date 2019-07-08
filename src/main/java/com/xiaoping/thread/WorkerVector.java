package com.xiaoping.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class WorkerVector {

//    private static List<Integer> mList = new ArrayList<>();
    private static Vector<Integer> mList = new Vector<>();
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    mList.add(i);
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    mList.add(i);
                }
            }
        };

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(mList.size());

    }
}
