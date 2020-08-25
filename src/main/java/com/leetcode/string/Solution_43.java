package com.leetcode.string;

/**
 * @author lwj
 * @date 2020/8/13 11:27
 */
public class Solution_43 {

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if ((len1 == 1 && num1.charAt(0) == '0') || (len2 == 1 && num2.charAt(0) == '0')) {
            return "0";
        }
        for (int i = len2 - 1; i >= 0; i--) {
            Integer integer = Integer.valueOf(String.valueOf(num2.charAt(i)));
//            integer = integer*Math.pow(10,len2-i-1);
        }
        return "";

    }

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
