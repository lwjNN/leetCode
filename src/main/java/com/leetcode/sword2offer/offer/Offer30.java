package com.leetcode.sword2offer.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * @author lwj
 * @date 2022/4/25 10:40
 */
public class Offer30 {

    private LinkedList<Integer> res;
    private LinkedList<Integer> helper;

    public Offer30() {
        res = new LinkedList();
        helper = new LinkedList();
    }

    public void push(int x) {
        if (helper.size() == 0 || x <= helper.getLast()) {
            helper.add(x);
        }
        res.add(x);
    }

    public void pop() {
        if (helper.getLast().equals(res.removeLast())){
            helper.removeLast();
        }
    }

    public int top() {
        return res.getLast();
    }

    public int min() {
        return helper.getLast();
    }

    public static void main(String[] args) {
        Offer30 o = new Offer30();
        o.push(512);
        o.push(-1024);
        o.push(-1024);
        o.push(512);
        o.pop();
        System.out.println(o.min());
        o.pop();
        System.out.println(o.min());
        o.pop();
        System.out.println(o.min());
    }
}
