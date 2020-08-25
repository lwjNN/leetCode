package com.leetcode.string;

/**
 * @author lwj
 * @date 2020/8/13 10:46
 */
public class Solution_415 {
    public static String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int abs = Math.abs(len1 - len2);
        for (int i = 0; i < abs; i++) {
            if (len1 > len2) {
                num2 = "0" + num2;
            } else {
                num1 = "0" + num1;
            }
        }
        int len = num1.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= len; i++) {
            res.append("0");
        }
        for (int i = len - 1; i >= 0; i--) {
            Integer i1 = Integer.valueOf(String.valueOf(num1.charAt(i)));
            Integer i2 = Integer.valueOf(String.valueOf(num2.charAt(i)));
            int sum = i1 + i2;
            char c = res.charAt(i + 1);
            Integer integer = Integer.valueOf(String.valueOf(c));
            sum += integer;
            if (sum >= 10) {
                res.setCharAt(i, String.valueOf(sum).charAt(0));
                res.setCharAt(i + 1, String.valueOf(sum % 10).charAt(0));
            } else {
                res.setCharAt(i + 1, String.valueOf(sum).charAt(0));
            }
        }
        return res.charAt(0)=='0'?res.substring(1).toString():res.toString();
    }

    public static String addStrings_1(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("999", "1"));
    }
}
