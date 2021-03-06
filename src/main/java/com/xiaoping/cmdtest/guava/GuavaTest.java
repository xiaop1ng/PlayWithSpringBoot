package com.xiaoping.cmdtest.guava;

import com.google.common.base.*;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;

import java.util.Collections;
import java.util.List;

public class GuavaTest {

    public static void main(String[] args) {
        Integer val1 = null;
        Integer val2 = 5;

        // 对于应用业务代码而言，Null 往往是导致混乱，疑难问题和模糊语义的元凶
        // 不要在 Set 中使用 null，或者把 null 作为 map 的键。使用特殊值代表 null 会让查找操作的语义更清晰
        // Optional<T> 表示可能为 null 的 T 型引用

        Optional<Integer> op1 = Optional.fromNullable(val1);
        Optional<Integer> op2 = Optional.fromNullable(val2);
        boolean isPresend1 = op1.isPresent();
        boolean isPresend2 = op2.isPresent();
        System.out.println("[isPresend1]" +  isPresend1); // false
        System.out.println("[isPresend2]" +  isPresend2); // true
        Integer ele1 = op1.or(0);
        Integer ele2 = op2.or(0);
        System.out.println(ele1 + ele2); // 5

        // Exception in thread "main" java.lang.IllegalArgumentException: val must lager than zero.
//        Preconditions.checkArgument(ele1 > 0, "val must lager than zero.");
        Preconditions.checkArgument(ele2 > 0, "val must lager than zero.");

        // Exception in thread "main" java.lang.NullPointerException: val is required.
//        Preconditions.checkNotNull(val1, "val is required.");

        int[] arr = {1, 2, 3};
        // Exception in thread "main" java.lang.IndexOutOfBoundsException: indexOfBound (3) must be less than size (3)
//        Preconditions.checkElementIndex(3, arr.length, "indexOfBound");

        List<Integer> list = Ints.asList(7,4,2,5,6,3,4,7,9,78,12,33,1);
        // Ordering impl Comparator 用户排序
        Ordering<Comparable> ordering = Ordering.natural();
        Collections.sort(list, ordering);
        System.out.println("[sort list:]");
        System.out.println(list);
        Collections.sort(list, ordering.reverse());
        System.out.println("[reverse sort list:]");
        System.out.println(list);
        Integer min = ordering.min(list);
        Integer max = ordering.max(list);
        System.out.println("[min]" + min);
        System.out.println("[max]" + max);

        boolean flag1 = Objects.equal("a", "a"); // true
        boolean flag2 = Objects.equal(null, "a"); // false
        System.out.println("[flag1]" + flag1);
        System.out.println("[flag2]" + flag2);


        Joiner joiner = Joiner.on(",").skipNulls();

        String items = joiner.join("'hello'", "'fine'", "'thanks'", null, "'goodbye'");

        System.out.println(items); // 'hello','fine','thanks','goodbye'

        String joinStr = Joiner.on(",").skipNulls().join(Ints.asList(3, 2, 1));

        System.out.println(joinStr);

        List<String> strList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(joinStr);

        strList.forEach(item -> {
            System.out.println(item);
        });

        String r = CharMatcher.whitespace().removeFrom("    h    e llo  ");
        System.out.println(r); // hello


        Range<Integer> range = Range.closed(0, 10); // 前闭后闭
        System.out.println(range.contains(1)); // true
        System.out.println(range.contains(0)); // true
        System.out.println(range.contains(-1)); // false
        System.out.println(range.contains(10)); // true
        System.out.println(range.contains(190)); // false

        Range<Integer> range1 = Range.open(15, 99); // 前开后开
//        Range<Integer> intersection = range.intersection(range1); // 交集 (5..10]
//        System.out.println("intersection->" +  intersection);
        Range<Integer> span = range.span(range1); // 跨度（区间） [0..99)
        System.out.println("span->" +  span);
        Range<Integer> gap = range.gap(range1); // 间隙 (10..15]
        System.out.println("gap->" +  gap);

        // 读 ByteSource CharSource
        // 写 ByteSink CharSink
        System.out.println("[sum]" + Integer.MAX_VALUE + 1); // 忽略溢出 21474836471
        int sum = IntMath.checkedAdd(Integer.MAX_VALUE, 1); // 异常 ArithmeticException
        System.out.println(sum); // safe sum



    }

}
