package com.leetcode.other;

/**
 * @author lwj
 * @date 2020/9/19 17:34
 */
public class Four {
    public int keyboard(int k, int n) {

        if (n == 1) {
            return 26;
        }
        if (n <= k) {
            double pow = Math.pow(26, n);
            return (int) pow % 1000000007;
        }else{
            if (k == 1){
                return getRes(k);
            }

        }
        return 1;
    }
    public int getRes(int x){
        int res = 26;
        for (int i = 1; i <x; i++) {
            res*=(res-i);
        }
        return res;
    }

    public static void main(String[] args) {
        Four s = new Four();
        System.out.println(s.getRes(3));
    }
}
