package com.xiaoping.algorithm;

public class CountingSort {

    public static void main(String[] args) {
        int [] arr = {2,0,2,1,1,0};
        int [] count = new int[3];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0)
                count[0]++;
            else if(arr[i] == 1)
                count[1]++;
            else
                count[2]++;
        }

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i);
            }
        }
    }

}
