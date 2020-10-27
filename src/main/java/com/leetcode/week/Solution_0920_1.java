package com.leetcode.week;

import java.util.*;

/**
 * @author lwj
 * @date 2020/9/20 10:31
 */
public class Solution_0920_1 {
    public static String reorderSpaces(String text) {
        List<String> list = new ArrayList<>();
        String[] s = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if(s[i].length() != 0){
                list.add(s[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == ' '){
                count++;
            }
        }
        if(list.size() == 1){
            sb.append(list.get(0));
            for (int k = 0; k < count; k++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int i = count / (list.size() - 1);
        int a = count % (list.size() - 1);
        for (int j = 0; j < list.size(); j++) {
            sb.append(list.get(j));
            if(j == list.size()-1){
                if(a == 0){
                    return sb.toString();
                }else{
                    for (int k = 0; k < a; k++) {
                        sb.append(" ");
                    }
                }
                return sb.toString();
            }
            for (int k = 0; k < i; k++) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorderSpaces("  this   is  a sentence "));
    }
}
