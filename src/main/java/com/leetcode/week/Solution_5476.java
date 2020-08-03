package com.leetcode.week;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author LWJ
 * @date 2020/8/2 10:42
 */
public class Solution_5476 {
    public static int getWinner(int[] arr, int k) {

        Deque<Integer> deque = new LinkedList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i]){
                max = arr[i];
            }
            deque.addLast(arr[i]);
            map.put(arr[i],0);
        }
        if(k>max){
            return max;
        }
        while (true){
            Integer num1 = deque.peekFirst();
            deque.removeFirst();
            Integer num2 = deque.peekFirst();
            deque.removeFirst();
            if(num1 == max || num2 == max){
                return max;
            }
            if(num1>num2){
                deque.addLast(num2);
                deque.offerFirst(num1);
                map.put(num1, map.get(num1)+1);
                if(map.get(num1) == k){
                    return num1;
                }
            }else{
                deque.addLast(num1);
                deque.offerFirst(num2);
                map.put(num2, map.get(num2)+1);
                if(map.get(num2) == k){
                    return num2;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = {1,11,22,33,44,55,66,77,88,99};
        int k =1000000000;
        System.out.println(getWinner(arr, k));
    }
}
