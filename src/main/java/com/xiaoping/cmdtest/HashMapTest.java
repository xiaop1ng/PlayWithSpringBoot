package com.xiaoping.cmdtest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        // hashmap 的实现？
        // 数组和链表的方式实现，当链表的长度超过 8 时，会将链表转换为红黑树
        List<Object> list = new ArrayList<>();
        // ArrayList 的实现？
        // 可变长度的动态数组
        List<Object> linkedList = new LinkedList<>();
        // linkedList 的实现？
        // 双向链表的实现，会存储上一个节点和下一个节点的位置
        Map<String, Object> concurrentMap = new ConcurrentHashMap<>();
        Map<String, Object> hashTable = new Hashtable<>();

    }
}
