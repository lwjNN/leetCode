package com.leetcode.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lwj
 * @date 2020/11/15 10:58
 */
public class Solution_1115_2 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int len = word1.length();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (word2.indexOf(word1.charAt(i) + "") < 0 || word1.indexOf(word2.charAt(i) + "") < 0) {
                return false;
            }
            if (map1.get(word1.charAt(i)) == null) {
                map1.put(word1.charAt(i), 1);
            } else {
                map1.put(word1.charAt(i), map1.get(word1.charAt(i)) + 1);
            }
            if (map2.get(word2.charAt(i)) == null) {
                map2.put(word2.charAt(i), 1);
            } else {
                map2.put(word2.charAt(i), map2.get(word2.charAt(i)) + 1);
            }
        }
        int[] arr1 = new int[map1.size()];
        int index= 0;
        for (Character c : map1.keySet()) {
            arr1[index++] = map1.get(c);
        }
        Arrays.sort(arr1);
        int[] arr2 = new int[map2.size()];
        int index2= 0;
        for (Character c : map2.keySet()) {
            arr2[index2++] = map2.get(c);
        }
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
