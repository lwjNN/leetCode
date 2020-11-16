package com.leetcode.week;

import java.util.*;

/**
 * @author lwj
 * @date 2020/11/15 11:18
 */
public class Solution_1115_3 {
    public int minOperations(int[] nums, int x) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<List<Integer>> resList = new ArrayList<>();
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[i] = nums[nums.length-1-i];
        }
        dfs(nums,x,deque, resList);
        dfs(newArr,x,deque, resList);
        if(resList.size() == 0){
            return -1;
        }
        List<Integer> integers = resList.get(0);
        int result = integers.size();
        for (int i = 1; i < resList.size() ; i++) {
            if(result>resList.get(i).size()){
                result = resList.get(i).size();
            }
        }
        return result;
    }

    private void dfs(int[] nums, int x, Deque<Integer> deque, List<List<Integer>> resList) {
        if(x == 0){
            resList.add(new ArrayList<>(deque));
            return;
        }
        if(x<0 || nums.length<1){
            return;
        }
        for (int i = 0; i < 2; i++) {
            int[] arr;
            int tar;
            if(i==0){
                tar = nums[0];
                deque.addLast(tar);
                arr = Arrays.copyOfRange(nums,1, nums.length);
            }else{
                tar = nums[nums.length -1];
                deque.addLast(tar);
                arr = Arrays.copyOfRange(nums,0, nums.length-1);
            }
            dfs(arr,x-tar, deque, resList);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution_1115_3 s = new Solution_1115_3();
        System.out.println(s.minOperations(new int[]{1, 1}, 3));
    }
}
