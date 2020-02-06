package com.xiaoping.cmdtest;

public class StringTest {

    // 当内存中 a 的值发生改变，其他线程中 cpu 缓存值会重新读取内存中的值
    private volatile int a = 1;

    // 被 transient 修饰的变量不会被序列化
    private transient String t = "test";

    public static void main(String[] args) {
        String s = "hello";

        s = "hello world"; // 这里相当于 s = new String("world");


        String s1 = s.substring(1, 2); // 前闭后开

        System.out.println(s1); // "o"

        // String 类被 final 修饰，表明构造一个 String 的时候就已经是不可修改的，String 里面提供的多数方法也是返回一个新的 String

        // `substring` -> Arrays.copyOfRange

        String s2 = "o";

        System.out.println(s1.equals(s2)); // `equals` -> 遍历 charArray 挨个比较

        s2.toCharArray();

//        String s3 = s.replace("l", "A"); // heAAo worAd

        String s3 = s.replace('l', 'A');

        System.out.println(s3);


        // new Array

//        public static Long valueOf(long l) {
//            final int offset = 128;
//            if (l >= -128 && l <= 127) { // will cache
//                return LongCache.cache[(int)l + offset];
//            }
//            return new Long(l);
//        }

        Long l1 = 1L;

        // long -> valueOf 保存了 [-128, 127] 的缓存，使用 valueOf 可能比 parseLong 省资源


        // volatile 的意思是可见的，常用来修饰某个共享变量，意思是当共享变量的值被修改后，
        // 会及时通知到其它线程上，其它线程就能知道当前共享变量的值已经被修改了。

        Test t = new TestImpl();
        t.test();

    }
}

interface Test {

    /**
     * 该接口方法被 default 修饰，实现类中可以不实现该方法，但该接口必须有默认实现
     */
    default void test() {
        System.out.println("test invoke!");
    }
}


class TestImpl implements  Test {

}