//package com.leetcode.week;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//
///**
// * @author lwj
// * @date 2020/9/27 10:27
// */
//public class Solution_0927_02 {
//    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
//        int sum = 0;
//        int ans = 0;
//        Deque<Integer> deque = new ArrayDeque<>();
//        for (int i = 0; i < customers.length; i++) {
//            int num = customers[i];
//            if(!deque.isEmpty() && deque.peek() != 4){
//                Integer integer = deque.removeLast();
//                if(integer + num <4){
//                    deque.addLast(4);
//                    continue;
//                }else{
//                    deque.addLast(4);
//                    num = num - (4-integer);
//                }
//
//            }
//            if (num <= 4) {
//                deque.addLast(num);
//                continue;
//            }
//            while (num > 4) {
//                deque.addLast(4);
//                num = num - 4;
//            }
//            if (num != 0) {
//                deque.addLast(num);
//            }
//        }
//        int index = 1;
//        while (!deque.isEmpty()){
//            Integer integer = deque.removeFirst();
//            System.out.println(integer);
//            ans+=integer*boardingCost - index * runningCost;
//            index++;
//        }
//
//    }
//
//}
//
//    public static void main(String[] args) {
//    }
//}
