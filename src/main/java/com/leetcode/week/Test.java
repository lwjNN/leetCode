package com.leetcode.week;

import java.util.*;

/**
 * @author lwj
 * @date 2022/7/10 11:02
 */
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(34);
        ans.add(5);

        System.out.println(ans);


        queue.add(1);
        queue.add(2);

        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
