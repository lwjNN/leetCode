package com.algorithm.chapter2.sort;

import java.util.Arrays;

/**
 * @author LWJ
 * @date 2020/5/17 9:48
 */
public class BubbeSort {


    public static void main(String[] args) {
        int[] arr = {5,4,7,2,8,3,0,1,99};
        sort(arr);
    }

    public static void sort(int[] arr){
        if (arr.length == 0){
            System.out.println("空数组");
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i -1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
