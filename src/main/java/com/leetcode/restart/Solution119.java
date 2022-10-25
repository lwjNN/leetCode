package com.leetcode.restart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwj
 * @date 2022/7/21 18:15
 */
public class Solution119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    cur.add(1);
                }else {
                    cur.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

}
