package com.leetcode.week;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lwj
 * @date 2020/9/6 10:29
 */
public class Solution_0906_2 {
    public int numTriplets(int[] nums1, int[] nums2) {
        int[] newNums1 = new int[nums1.length];
        int[] newNums2 = new int[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            newNums1[i] = nums1[i] * nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            newNums2[i] = nums2[i] * nums2[i];
        }
        int res = 0;
        for (int i = 0; i < newNums1.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < nums2.length; j++) {
                if(set.contains(j)){
                    continue;
                }
                if(newNums1[i] % nums2[j] != 0){
                    continue;
                }
                int count = getCount(nums2, newNums1[i] / nums2[j], set);
                if (count != 0){
                    set.add(j);
                }
            }
        }
        for (int i = 0; i < newNums2.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < nums1.length; j++) {
                if(set.contains(j)){
                    continue;
                }
                if(newNums2[i] % nums1[j] != 0){
                    continue;
                }
                int count = getCount(nums1, newNums2[i] / nums1[j], set);
                if (count != 0){
                    set.add(j);
                }
            }
        }
        return res;
    }

    public int getCount(int[] nums, int tar, Set<Integer> set){
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == tar){
                set.add(i);
                res++;
            }
        }
        return res;
    }
}
