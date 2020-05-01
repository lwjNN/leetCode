package com.leetcode.other;

public class BitOperator {

    public static int add(int a, int b){
        int res = a;
        int xor = a^b;//获取原位和
        int forword = (a&b)<<1;//获取进位和。

        if(forword != 0){
            res = add(xor, forword);
        }else{
            res = xor;
        }
        return res;
    }

    public static int minus(int a, int b){
        return add(a,~b+1);
    }

    public static void main(String[] args) {
        int add = add(99, 213);
        System.out.println(add);
        int minus = minus(29, 7);
        System.out.println(minus);
    }
}
