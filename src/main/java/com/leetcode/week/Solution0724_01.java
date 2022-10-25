package com.leetcode.week;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwj
 * @date 2022/7/24 10:26
 */
public class Solution0724_01 {
    public char repeatedCharacter(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                return s.charAt(i);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        return 'a';
    }
}
