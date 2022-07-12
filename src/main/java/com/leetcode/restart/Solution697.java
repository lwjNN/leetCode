package com.leetcode.restart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lwj
 * @date 2022/7/5 17:05
 */
public class Solution697 {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(nums[i], tmp);
            }else {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            }
        }
        int du = 0;
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > du){
                du = entry.getValue().size();
                ans = entry.getValue().get(du - 1) - entry.getValue().get(0) + 1;
            }else if (entry.getValue().size() == du){
                ans = Math.min(ans, entry.getValue().get(du - 1) - entry.getValue().get(0) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }
}
