package com.leetcode.everyday;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author LWJ
 * @date 2020/6/10 9:34
 */
public class Solution_09 {
    public static boolean isPalindrome_1(int x) {
        if(x<0){
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        int tem = x;
        while (tem>0){
            queue.add(tem%10);
            tem = tem/10;
        }
        double res = 0d;
        while (!queue.isEmpty()){
            res += queue.peek() * Math.pow(10, queue.size()-1);
            queue.poll();
        }
        return res == x;
    }

    public static boolean isPalindrome_2(int x) {
        if(x<0){
            return false;
        }
        int res = 0;
        int tmp = x;
        while (tmp>0){
            res = res*10 + tmp%10;
            tmp = tmp/10;
        }
        return res == x;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome_1(2147483647));
    }
}
