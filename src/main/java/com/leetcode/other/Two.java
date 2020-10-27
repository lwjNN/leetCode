package com.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lwj
 * @date 2020/9/19 15:11
 */
public class Two {
    public boolean isMagic(int[] target) {
        int[] tmp = new int[target.length];
        for (int i = 0; i < target.length; i++) {
            tmp[i] = target[i];
        }
        Arrays.sort(tmp);
        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < target.length; i= i+2) {
//            list
//        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,3};
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp);
        System.out.println(Arrays.toString(arr));
    }
}
