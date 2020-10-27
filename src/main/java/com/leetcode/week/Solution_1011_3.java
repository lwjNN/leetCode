package com.leetcode.week;

/**
 * @author lwj
 * @date 2020/10/11 10:46
 */
public class Solution_1011_3 {
    public boolean checkPalindromeFormation(String a, String b) {
        if(helper(a) || helper(b)){
            return true;
        }
        int len = a.length();
        for (int i = 1; i < len/2; i++) {
            String aPre = a.substring(0,i);
            String aLast = a.substring(i);
            String bPre = b.substring(0, i);
            String bLast = b.substring(i);

            String newStr1 = aPre + bLast;
            String newStr2 = bPre + aLast;
            if(helper(newStr1) || helper(newStr2)){
                return true;
            }

        }
        return false;
    }

    public boolean helper(String s){
        StringBuilder sb = new StringBuilder(s);
        if(s.equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_1011_3  s = new Solution_1011_3();
        System.out.println(s.checkPalindromeFormation("x", "y"));
    }
}
