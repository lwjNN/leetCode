package com.leetcode.everyday;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 不创建多余的栈空间，只是在原有栈上存储最小元素。使用node
 *
 * @author lwj
 */
public class Solution_155_2 {

    public static class Node {
        //存储当前元素
        private int val;
        //存储最小值
        private int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Stack<Node> stack;


    public Solution_155_2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Node(x, x));
        } else {
            stack.push(new Node(x, Math.min(x, stack.peek().min)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        // 返回栈顶元素中的元素值。
        return stack.peek().val;
    }

    public int getMin() {
        // 返回栈顶元素的最小值
        return stack.peek().min;
    }
}
