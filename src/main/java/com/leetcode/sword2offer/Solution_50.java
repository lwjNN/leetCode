package com.leetcode.sword2offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 * 限制：
 * 0 <= s 的长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/6/3 9:47
 */
public class Solution_50 {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        for (Character c:
             s.toCharArray()) {
            map.put(c,!map.containsKey(c));
        }
        for (Character c:
                s.toCharArray()) {
            if(map.get(c)) {
                return c;
            }
        }
        return ' ';

    }
}
