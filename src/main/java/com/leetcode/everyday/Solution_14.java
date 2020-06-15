package com.leetcode.everyday;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/6/15 14:53
 */
public class Solution_14 {
    //1.横向比较，两两比较公共最长前缀，如果比较中有出现空串，直接返回
    public String longestCommonPrefix_1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getCommonPrefix(prefix,strs[i]);
            if("".equals(prefix)){
                return prefix;
            }
        }
        return prefix;
    }

    public String getCommonPrefix(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < min && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0,index);
    }


    //2.纵向比较，用第一个字符串的每个字符去遍历数组后边所有的字符串
    public String longestCommonPrefix_2(String[] strs){
        if (strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if(i == strs[j].length() || c != strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }


    public static void main(String[] args) {
        Solution_14 s = new Solution_14();
        String[] arr = {"flower","flow","floe","flo"};
        System.out.println(s.longestCommonPrefix_2(arr));
    }

}
