package com.xiaoping.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WorkerConcurrentHashMap {

    // private static Map<String, String> map = new HashMap<>();

    private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < 1000000; i++) {
                    map.put(String.valueOf(i), Integer.toBinaryString(i));
                }

            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < 1000000; i++) {
                    map.put(String.valueOf(i), Integer.toBinaryString(i));
                }

            }
        };

        t1.start();

        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}
