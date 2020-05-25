package com.algorithm.chapter2.sort;

import java.util.Arrays;

/**
 * 选择排序。
 * 双重for循环，每次都将最大的元素往后放
 */
public class SelectSort {

    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < N-i; j++) {
                if (max < a[j]) {
                    max = a[j];
                    index = j;
                }
            }
            int temp = a[N-i-1];
            a[N-i-1] = max;
            a[index] = temp;
        }

        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,3,6,5,8,7};
        sort(arr);
    }

}
