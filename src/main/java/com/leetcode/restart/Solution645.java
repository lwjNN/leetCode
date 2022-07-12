package com.leetcode.restart;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwj
 * @date 2022/7/5 16:25
 */
public class Solution645 {
    public static int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        int[] ans = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)){
                ans[1] = i;
            }else if (map.get(i) == 2){
                ans[0] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findErrorNums(new int[]{1, 2, 2, 4}).toString());
    }
}
