package com.leetcode.week;

/**
 * @author LWJ
 * @date 2020/7/20 11:47
 */
public class Solution_1518 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles>=numExchange){
            res+=numBottles/numExchange;
            numBottles = numBottles/numExchange + numBottles%numExchange;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
    }
}
