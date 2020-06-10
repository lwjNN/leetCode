package com.leetcode.everyday;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/5/28 9:27
 */
public class Solution_394 {
//    public String decodeString(String s) {
//        Stack<String> stackStr = new Stack();
//        Stack<Integer> stackInt = new Stack();
//        int num = 0;
//        String tempStr = "";
//        for (Character c : s.toCharArray()) {
//            if (c == '[') {
//                stackInt.push(num);
//                num = 0;
//            } else if (c >= '0' && c <= '9') {
//                if(tempStr != null && !"".equals(tempStr) ){
//                    stackStr.push(tempStr);
//                }
//                tempStr = "";
//                num = num * 10 + Integer.parseInt(c + "");
//            }else if (c == ']'){
//                if(tempStr != null && !"".equals(tempStr) ){
//                    stackStr.push(tempStr);
//                }
//                tempStr = "";
//                int pop = stackInt.pop();
//                String popStr = stackStr.pop();
//                String temp = "";
//                for (int i = 1; i <= pop; i++) {
//                    temp += popStr;
//                }
//                if(!stackStr.isEmpty()) {
//                    stackStr.push(stackStr.pop() +temp);
//                }else{
//                    stackStr.push(temp);
//                }
//            }else {
//                    tempStr+=c;
//                }
//        }
//        return stackStr.pop();
//    }

    public static void main(String[] args) {
//        Solution_394 so = new Solution_394();
//        System.out.println(so.decodeString("10[leetcode]"));
//        Stack stack = new Stack();
//        stack.push(null);
//        stack.push(null);
//        stack.push(null);
//        System.out.println(stack.pop());
    }
}
