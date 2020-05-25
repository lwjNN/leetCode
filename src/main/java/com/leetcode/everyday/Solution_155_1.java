package com.leetcode.everyday;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 辅助栈方式，多创建一个栈空间
 * @author lwj
 */
public class Solution_155_1 {

    private Stack<Integer> stack;

    /**
     * 辅助栈，栈顶只存储最小元素
     */
    private Stack<Integer> minStack;

    public Solution_155_1() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x<minStack.peek()){
            //如果辅助栈是空的，直接push
            //如果不为空。就比较要入栈的元素和辅助栈顶元素大小，如果x小。压入辅助栈，否则不操作。
            minStack.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if(pop == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
