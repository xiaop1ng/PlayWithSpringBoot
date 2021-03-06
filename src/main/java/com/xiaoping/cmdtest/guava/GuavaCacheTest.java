package com.xiaoping.cmdtest.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.gson.JsonObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 缓存，注意这里的缓存是单机的，而非分布式的
 */
public class GuavaCacheTest {

    public static void main(String[] args) {

        LoadingCache<String, JsonObject> cacheObj = CacheBuilder.newBuilder()
                .maximumSize(1000) // 对象大小 1000 b
                .expireAfterWrite(3, TimeUnit.SECONDS) // 写入 3s 后过期
                .build(new CacheLoader<String, JsonObject>() {
                    @Override
                    public JsonObject load(String key) throws Exception {
                        System.out.println("cache invoke key is -> " + key);
                        JsonObject json = new JsonObject();
                        json.addProperty("name", "tom");
                        json.addProperty("key", key);
                        return json;
                    }
                });

        try {
            while (true) {
                System.out.println( cacheObj.get("first") );
                Thread.sleep(1000); // 1s
                Random random = new Random();
                int i = random.nextInt(100);
                if (i%2 == 0) {
                    System.out.println("手动删除缓存");
                    cacheObj.invalidateAll(); // 所有清除
//                    cacheObj.invalidate("first"); // 清除某个键
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        cache invoke key is -> first
//        {"name":"tom","key":"first"}
//        手动删除缓存
//        cache invoke key is -> first
//        {"name":"tom","key":"first"}
//        手动删除缓存
//        cache invoke key is -> first
//        {"name":"tom","key":"first"}
//        {"name":"tom","key":"first"}
//        {"name":"tom","key":"first"}
//        cache invoke key is -> first
//        {"name":"tom","key":"first"}
//        手动删除缓存
//        cache invoke key is -> first
//        {"name":"tom","key":"first"}
//        {"name":"tom","key":"first"}
//        手动删除缓存
//        cache invoke key is -> first
//        {"name":"tom","key":"first"}
//        {"name":"tom","key":"first"}
//        手动删除缓存
//        cache invoke key is -> first
//        {"name":"tom","key":"first"}
    }

}
