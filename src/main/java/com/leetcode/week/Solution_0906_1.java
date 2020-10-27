package com.leetcode.week;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwj
 * @date 2020/9/6 10:29
 */
public class Solution_0906_1 {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 97; i <= 122; i++) {
            map.put((char)i,i);
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '?'){
                if (i == 0){

                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        char c = 'A';
        System.out.println((char) (c + 1));
    }
}
