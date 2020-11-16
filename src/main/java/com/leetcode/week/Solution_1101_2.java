package com.leetcode.week;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lwj
 * @date 2020/11/1 10:27
 */
public class Solution_1101_2 {
    String[] arr = new String[]{"a","e","i","o","u"};
    public int countVowelStrings(int n) {
        List<List<String>> resList = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<>();
        backtrack(n, 0, resList, deque);
        System.out.println(resList);
        return resList.size();
    }

    private void backtrack(int n, int index, List<List<String>> resList, Deque<String> deque) {
        if(deque.size() == n){
            resList.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            deque.addLast(arr[i]);
            backtrack(n, i, resList, deque);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution_1101_2 s= new Solution_1101_2();
        System.out.println(s.countVowelStrings(33));
    }
}
