package com.leetcode.dataStructure;

import java.util.Stack;

/**
 * @author lwj
 * @date 2022/6/23 20:07
 */
public class Solution232 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public Solution232() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()){
            return stack2.peek();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
