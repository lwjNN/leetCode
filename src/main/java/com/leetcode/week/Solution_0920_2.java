package com.leetcode.week;

import java.util.*;

/**
 * @author lwj
 * @date 2020/9/20 10:59
 */
public class Solution_0920_2 {
    public static int maxUniqueSplit(String s) {
        if (s.length() == 1) {
            return 1;
        }
        String res = s.replaceAll(String.valueOf(s.charAt(0)), "");
        if (res.length() == 0) {
            return 1;
        }
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {

            if(i != s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                sb.append(s.charAt(i));
                if(sb.length() < 2){
                    continue;
                }
            }
            if (sb.length() == 0 && set.contains(String.valueOf(s.charAt(i)))) {
                sb.append(s.charAt(i));
            } else if (sb.length() != 0) {
                sb.append(s.charAt(i));
            } else {
                result++;
                set.add(String.valueOf(s.charAt(i)));
            }
            if (sb.length() != 0 && !set.contains(sb.toString())) {
                result++;
                sb = new StringBuilder();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("abbdsb"));
    }
}
