package com.leetcode.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * <p>
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/10/29 10:48
 */
public class Solution_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> resList = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return resList;
        }

        int length = s.length();
        Deque<String> deque = new ArrayDeque<>();
        dfs(s, length, 0, 0, resList, deque);
        return resList;
    }

    private void dfs(String s, int length, int split, int begin, List<String> resList, Deque<String> deque) {
        if (begin == length) {
            if (split == 4) {
                resList.add(String.join(".", deque));
            }
        }
        if ((length - begin < (4 - split)) || (length - begin > 3 * (4 - split))) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (begin + i >= length) {
                break;
            }

            int ipSegment = judgeIfIpSegment(s, begin, begin + i);
            if(ipSegment != -1){
                deque.addLast(ipSegment+"");
                dfs(s, length, split+1, begin+i+1, resList, deque);
                deque.removeLast();
            }
        }
    }
    public int judgeIfIpSegment(String s, int begin, int end) {
        int len = end - begin + 1;
        if (len > 1 && s.charAt(begin) == '0') {
            return -1;
        }
        int res = 0;
        for (int i = begin; i <= end; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        if (res > 255){
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_93 s = new Solution_93();
        System.out.println(s.restoreIpAddresses("101023"));
    }
}
