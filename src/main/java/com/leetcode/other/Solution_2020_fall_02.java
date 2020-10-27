package com.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lwj
 * @date 2020/9/15 10:00
 */
public class Solution_2020_fall_02 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int res = 0;
        int r = drinks.length - 1;
        for (int i = 0; i < staple.length; i++) {
            while (r >= 0 && (drinks[r] + staple[i]) > x){
                r--;
            }
            res += (r+1);
        }
        int mod = (int)1e9 + 7;
        return (int) (res % mod);
    }
}
