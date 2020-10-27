package com.leetcode.week;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lwj
 * @date 2020/9/27 10:27
 */
public class Solution_0927_01 {
    public int minOperations(String[] logs) {
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < logs.length; i++) {
            if(!deque.isEmpty()&&logs[i].equals("../")){
                deque.removeLast();
            }else if(logs[i].equals("./")){
                continue;
            }else if(logs[i].equals("../")){
                continue;
            }else {
                deque.addLast(logs[i]);
            }
        }
        return deque.size();
    }
}
