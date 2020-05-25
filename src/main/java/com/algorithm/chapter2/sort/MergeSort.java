package com.algorithm.chapter2.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 使用递归、分治法
 */
public class MergeSort {

    private static int[] aux;

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = arr[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > high) {
                arr[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }

    public static void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr,low,mid,high);

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {6,4,8,3,9,1,2};

        sort(arr);
    }

}
