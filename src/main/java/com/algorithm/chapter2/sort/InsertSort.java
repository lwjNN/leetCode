package com.algorithm.chapter2.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void sort(int[] arr){
        int N = arr.length;
        for (int i = 1; i<N;i++){
            for (int j = i; j >0; j--) {
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,6,5,9,4};

        sort(arr);
    }
}
