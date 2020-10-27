package com.leetcode.other;

/**
 * @author lwj
 * @date 2020/9/19 15:02
 */
public class One {
    public int paintingPlan(int n, int k) {
        if(k<n){
            return 0;
        }
        if(k == n*n){
            return 1;
        }
        for (int i = n; i < n*n; i++) {
            if(i == n){
                return n*2;
            }
            if(i<2*n -1){
                continue;
            }
//            if()


        }
        return 1;
    }

    public int getRes(int x, int y){
        int res = 0;
        for (int i = x+1; i < y; i++) {
            res += i*(i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        One s = new One();
        System.out.println(s.getRes(2, 4));
    }
}
