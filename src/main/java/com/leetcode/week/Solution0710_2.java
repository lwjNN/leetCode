package com.leetcode.week;

import java.util.*;

/**
 * @author lwj
 * @date 2022/7/10 10:28
 */
public class Solution0710_2 {
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> help = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    public Solution0710_2() {
        for (int i = 1; i <= 1000 ; i++) {
            queue.add(i);
        }
    }

    public int popSmallest() {
        if (help.size() == 0 || queue.peek() < help.peek()){
            return queue.poll();
        }
        if (queue.peek() == help.peek()){
            help.poll();
            return queue.poll();
        }
        return help.poll();
    }

    public void addBack(int num) {
        List<Integer> list = new ArrayList<>();
        list.add(num);
        while (help.size() > 0){
            list.add(help.poll());
        }
        Collections.sort(list);
        for (Integer i : list) {
            help.add(i);
        }

    }
}
