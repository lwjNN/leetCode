package com.leetcode.week;

/**
 * @author lwj
 * @date 2020/11/1 10:27
 */
public class Solution_1101_1 {
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        for (int j = 0; j < pieces.length; j++) {
            if(pieces[j].length>1){
                for (int i = 0; i < pieces[j].length; i++) {
                    for (int k = 0; k < arr.length; k++) {
                        if(pieces[j][i] == arr[k]){

                        }
                    }
                }
            }else{

            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Solution_1101_1.canFormArray(new int[]{15, 88}, new int[][]{{88}, {15}}));
    }
}
