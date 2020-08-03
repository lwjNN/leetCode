package com.leetcode.sword2offer;

import org.apache.logging.log4j.util.Strings;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 限制：
 * 1 <= s 的长度 <= 8
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/7/1 13:46
 */
public class Solution_38 {
    public static String[] permutation(String s) {
        String[][] arr = new String[s.length()][];
        arr[0] = new String[]{s.substring(0, 1)};
        for (int i = 1; i < s.length(); i++) {
            Set<String> set = get(arr[i - 1], s.charAt(i));
            String[] array = set.stream().toArray(str -> new String[str]);
            arr[i] = array;
        }
        return arr[s.length()-1];
    }

    public static Set<String> get(String[] arr, char c) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= arr[i].length(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[i].substring(0, j)).append(c).append(arr[i].substring(j));
                set.add(sb.toString());
            }
        }
        return set;
    }

    public static void main(String[] args) {

        String[] abcs = permutation("b");
        System.out.println(Arrays.toString(abcs));
//        String[] str = {"acb", "bca", "abc", "cba", "cab", "bac"};
//        Set<String> c = get(str, 'c');
//        System.out.println(c);
//
//
//        Set<String> s = new HashSet<>();
//        s.add("a");
//        s.add("b");
//        String[] array = s.stream().toArray(str1 -> new String[str1]);
//        System.out.println(Arrays.toString(array));
    }

}
