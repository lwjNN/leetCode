package com.leetcode.week;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lwj
 * @date 2022/7/3 10:27
 */
public class Solution0703_1 {
    public static String decodeMessage(String key, String message) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            if (map.containsKey(key.charAt(i))){
                continue;
            }
            if (key.charAt(i) == ' '){
                continue;
            }

            map.put(key.charAt(i), 'a' + index);
            index++;
        }
        String ans = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i)== ' '){
                ans += " ";
                continue;
            }
            ans += (char) map.get(message.charAt(i)).intValue();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }
}
