package com.xiaoping.cmdtest.guava;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * 异步操作 ListenableFutures
 *
 * 适用场景： 系统初始化时读取配置文件
 */
public class GuavaListenableFutureTest {

    public static void main(String[] args) {

        System.out.println("invoke!");

        ListeningExecutorService service =
                MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture<Map> future = service.submit(new Callable() {

            @Override
            public Map call() throws Exception {
                Thread.sleep(3000); // sleep 3s
                System.out.println("call");
                Map<String, String> map = new HashMap<>();
                map.put("err", "0");
                map.put("msg", "succes");
                return map;
            }
        });

        System.out.println("balabala...");

        Futures.addCallback(future, new FutureCallback<Map>() {

            public void onSuccess(@Nullable Map o) {
                System.out.println(String.valueOf( o.get("err") ) + "|" +  String.valueOf(o.get("msg")) );
                System.out.println("success");
            }


            public void onFailure(Throwable throwable) {
                System.out.println("failed");
            }
        }, service);

        System.out.println("do something!");


//        invoke!
//        balabala...
//        do something!
//        call
//        0|succes
//        success

    }
}
