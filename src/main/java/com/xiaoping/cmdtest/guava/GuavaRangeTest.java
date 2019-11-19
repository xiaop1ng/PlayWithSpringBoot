package com.xiaoping.cmdtest.guava;

import com.google.common.collect.Range;

public class GuavaRangeTest {

    public static void main(String[] args) {
        Range<Integer> range = Range.closed(1, 2); // 前闭后闭

        Range<Integer> range1 = Range.closed(3, 4); // 前闭后闭
        Range<Integer> range2 = Range.closed(4, 7); // 前闭后闭
        Range<Integer> range3 = Range.closed(5, 6); // 前闭后闭

        System.out.println(range.isConnected(range1)); // false
        System.out.println(range.isConnected(range2)); // false
        System.out.println(range.isConnected(range3)); // false
        System.out.println(range1.isConnected(range2));// true
        System.out.println(range1.isConnected(range3));// false
        System.out.println(range2.isConnected(range3));// true

    }
}
