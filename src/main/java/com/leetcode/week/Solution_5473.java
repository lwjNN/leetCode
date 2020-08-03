package com.leetcode.week;

/**
 * @author LWJ
 * @date 2020/7/26 10:45
 */
public class Solution_5473 {
    public static int minFlips(String target) {
        int zeroLen = 0;
        int oneLen = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '0') {
                zeroLen++;
            } else {
                oneLen++;
            }
        }
        if (zeroLen == target.length()) {
            return 0;
        }
        if (oneLen == target.length()) {
            return 1;
        }
        String substring = target.substring(target.indexOf('1'));
        int count = 0;
        int oneL = 1;
        for (int i = 1; i < substring.length(); i++) {
            if (substring.charAt(i-1) == '0' && substring.charAt(i) == '1') {
                count++;
            } else if (substring.charAt(i) == '1') {
                oneL++;
            }
        }
        if(oneL == substring.length()){
            return 1;
        }
        if(count == 0){
            return 2;
        }else if(substring.charAt(substring.length()-1) == '0'){
            return 2+2*count;
        }
        return 1+2*count;

    }

    public static void main(String[] args) {
        System.out.println(minFlips("00111"));
    }
}
