package com.leetcode.week;

import java.util.Arrays;

/**
 * @author lwj
 * @date 2022/7/10 10:28
 */
public class Solution0710_1 {
    public int fillCups(int[] amount) {
        int ans = 0;
        Arrays.sort(amount);
        if (amount[0] == 0 && amount[1] == 0){
            return amount[2];
        }
        if (amount[2] > amount[0] + amount[1]){
            return amount[2];
        }
        ans = amount[0] + amount[1] + amount[2];
        if (ans % 2 == 0) return ans / 2;
        return ans / 2 + 1;
    }
}
