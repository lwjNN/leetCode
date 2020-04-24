package com.suanfatujie;

public class selectSort {

    public int findMin(int[] arr){
        int smallest = arr[0];
        int smallest_index = 0;

        for (int i = 0; i < arr.length; i++) {
            if(smallest<arr[i]){
                smallest = arr[i];
                smallest_index = i;
            }
        }
        return smallest_index;
    }

    public void selectionSort(int[] arr){
        int[] newArr = {};
        for (int i = 0; i < arr.length; i++) {
            int min_index = findMin(arr);
        }
    }

}
