package com.leetcode.other;

import com.leetcode.util.TimeTool;


/**
 * 斐波那契数列两种方式实现
 * 1,1,2,3,5,8,13,21,34
 * 1、递归(最慢)
 * 2、更新赋值
 * 3、动态规划，和第二种差别不大。时间基本相等
 */
public class Fibonacci {

    public static int fib_dp(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        int res = 0;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            res = dp[i];
        }
        return res;
    }

    public static int fibRecursive(int n){
        if(n<3){
            return 1;
        }
        return fibRecursive(n-1) + fibRecursive(n-2);
    }

    public static int fibCycle(int n){
        if(n<3){
            return 1;
        }
        int sum = 0;
        int first = 1;
        int second = 1;
        for (int i = 1; i < n-1; i++) {
            sum = first + second;
            second = first;
            first = sum;
        }
        return sum;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        TimeTool.check("fibRecursive", new TimeTool.Task() {
            @Override
            public void excute() {
                System.out.println(fibRecursive(30));
            }
        });

        TimeTool.check("fibCycle", new TimeTool.Task() {
            @Override
            public void excute() {
                System.out.println(fibCycle(20000));
            }
        });

        TimeTool.check("fib_dp", new TimeTool.Task() {
            @Override
            public void excute() {
                System.out.println(fib_dp(20000));
            }
        });




    }

}
