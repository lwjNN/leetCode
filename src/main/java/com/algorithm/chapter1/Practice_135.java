package com.algorithm.chapter1;

import java.util.Stack;

/**
 * 打印一个整数的二进制表示
 */
public class Practice_135 {

    public static void getBinary(int N){
        Stack<Integer> stack = new Stack<>();
        while (N > 0){
            stack.push(N % 2);
            N = N/2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        getBinary(32);
    }
}
