package com.leetcode.arrays;

/**
 * @author LWJ
 * @date 2020/7/12 23:39
 */
public class Solution_167 {
    public int[] twoSum(int[] numbers, int target) {
        int pre = 0;
        int last = numbers.length - 1;
        int[] res = new int[2];
        for (int i = 0; i < numbers.length / 2; i++) {
            if (numbers[pre] + numbers[last] > target) {
                last--;
            } else if (numbers[pre] + numbers[last] < target) {
                pre++;
            } else {
                res[0] = pre + 1;
                res[1] = last + 1;
                break;
            }
        }
        return res;
    }
}
