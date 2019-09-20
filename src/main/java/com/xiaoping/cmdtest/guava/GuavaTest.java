package com.xiaoping.cmdtest.guava;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import java.util.Collections;
import java.util.List;

public class GuavaTest {

    public static void main(String[] args) {
        Integer val1 = null;
        Integer val2 = 5;
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
        Ordering<Comparable> ordering = Ordering.natural();
        Collections.sort(list, ordering);
        System.out.println("[sort list:]");
        System.out.println(list);

    }

}
