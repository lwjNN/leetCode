package com.suanfatujie;

import java.util.Arrays;

public class selectSort {

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                    index = j;
                }
            }

            int temp = arr[arr.length - i - 1];
            arr[arr.length-i-1] = max;
            arr[index] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,7,1};
        int[] ints = selectionSort(arr);
        System.out.println(Arrays.toString(ints));
    }

}
