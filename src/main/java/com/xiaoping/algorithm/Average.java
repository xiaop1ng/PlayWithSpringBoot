package com.xiaoping.algorithm;

public class Average {

    public static void main(String[] args) {
        int v1 = 1023948392;
        int v2 = 1438478978;

        System.out.println( (v1 + v2)/2 ); // 溢出问题 -916269963

        System.out.println( v1 + (v2 - v1)/2 ); // 1231213685
    }
}
