package com.leetcode.sword2offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/5/21 10:09
 */
public class Solution_09 {

    /**
     * stack1 作为主栈，增加元素都放在本栈中，如果删除元素，则需要将stack1的数据全部逆转到stack2中，
     * stack2 作为辅助栈，主要作用于删除元素，如果stack2有值，直接弹出即可，如果空了，再将stack1逆转放入stack2再弹出
     */
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Solution_09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        Solution_09 so = new Solution_09();
        so.appendTail(3);
        so.appendTail(4);
        so.appendTail(5);
        so.appendTail(6);
        so.appendTail(7);
        for (int i = 0; i < 9; i++) {
            System.out.println(so.deleteHead());
        }
    }
}
