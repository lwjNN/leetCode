package com.leetcode.everyday;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_0428 {

    public static int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.keySet().contains(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i]) + 1);
            }
        }
        int[] ints = map.keySet().stream().filter(key -> map.get(key) == 1).mapToInt(Integer::intValue).toArray();
        return ints;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,10,4,1,4,3,3};
        int[] ints = singleNumbers(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);

        }
    }


}
