package com.leetcode.other;

import com.leetcode.util.TimeTool;

import java.lang.reflect.Method;
import java.security.Timestamp;

/**
 * 斐波那契数列两种方式实现
 * 1,1,2,3,5,8,13,21,34
 * 1、递归
 * 2、更新赋值
 */
public class Fibonacci {
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
                System.out.println(fibRecursive(50));
            }
        });

        TimeTool.check("fibCycle", new TimeTool.Task() {
            @Override
            public void excute() {
                System.out.println(fibCycle(50));
            }
        });
    }

}
