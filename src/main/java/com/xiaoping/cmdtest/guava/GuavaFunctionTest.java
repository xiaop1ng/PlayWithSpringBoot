package com.xiaoping.cmdtest.guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.xiaoping.utils.DataRow;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GuavaFunctionTest {

    public static void main(String[] args) {

        Function<Date, String> function = new Function<Date, String>() {
            @Override
            public String apply(@Nullable Date date) {
                return new SimpleDateFormat("yyyy-MM-dd").format(date);
            }
        };

        // 一个好的 Function 实现应该没有副作用，也就是说对象作为参数传递方法调用 `apply` 方法后应保持不变
        System.out.println( function.apply(new Date()) );

        DataRow data = new DataRow();
        data.set("1", "hello");
        data.set("2", "world!");

        Function function1 = Functions.forMap(data, 0); // apply 方法会返回 map 对应的值

        System.out.println( function1.apply("1") ); // hello
        System.out.println( function1.apply("2") ); // world
        System.out.println( function1.apply("3") ); // 0
        System.out.println(data);


    }

}
