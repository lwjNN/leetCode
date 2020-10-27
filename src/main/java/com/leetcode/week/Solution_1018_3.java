package com.leetcode.week;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lwj
 * @date 2020/10/18 10:55
 */
public class Solution_1018_3 {
    public int bestTeamScore(int[] scores, int[] ages) {
        if(ages.length == 1){
            return scores[0];
        }
        int[] arr = new int[ages.length];
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            int score = scores[i];
            arr[i] = dp(i, score, age, scores, ages, score);
        }

        return getMax(arr);
    }

    public int dp(int index, int score, int age, int[] scores, int[] ages, int sum) {
        for (int i = 0; i < ages.length; i++) {
            if(i == index){
                continue;
            }
            if (ages[i] < age && scores[i] < score) {
                sum += scores[i];
            }
            if(ages[i] >= age && scores[i] >= score){
                sum += scores[i];
            }
        }
        return sum;
    }

    public int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution_1018_3 s = new Solution_1018_3();
        int[] scores = {9,2,8,8,2};
        int[] ages = {4,1,3,3,5};
        System.out.println(s.bestTeamScore(scores, ages));
    }
}
