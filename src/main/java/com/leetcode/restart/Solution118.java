package com.leetcode.restart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwj
 * @date 2022/7/21 18:15
 */
public class Solution118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    rowList.add(1);
                }else {
                    rowList.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(rowList);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generate(3));
    }

}
