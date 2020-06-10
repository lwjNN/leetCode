package com.leetcode.week;

import java.util.Arrays;

/**
 * @author LWJ
 * @date 2020/5/31 11:17
 */
public class Solution_5425 {
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxh = 0;
        int maxw = 0;
        int lenH = horizontalCuts.length;
        int lenW = verticalCuts.length;
        if(horizontalCuts.length == 1 ){
            maxh = Math.max(h - horizontalCuts[0], horizontalCuts[0] - 0);
        }else{
            int[] newH = new int[lenH+1];
            Arrays.sort(horizontalCuts);
            newH[0] = horizontalCuts[0];
            newH[1] = h-horizontalCuts[lenH-1];
            for (int i = 0; i < lenH-1; i++) {
                newH[i+2] =Math.abs(horizontalCuts[i] - horizontalCuts[i+1]);
            }
            maxh = getMax(newH);
        }
        if(verticalCuts.length == 1){
            maxw = Math.max(w - verticalCuts[0], verticalCuts[0] - 0);
        }else{
            int[] newW = new int[lenW+1];
            Arrays.sort(verticalCuts);
            newW[0] = verticalCuts[0];
            newW[1] = w-verticalCuts[lenW-1];
            for (int i = 0; i < lenW-1; i++) {
                newW[i+2] =Math.abs(verticalCuts[i] - verticalCuts[i+1]);
            }
            maxw = getMax(newW);
        }
        return maxh*maxw;
    }

    public static int getMax(int[] nums){
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if(max<nums[i]){
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int h = 8;
        int w = 5;
        int[] arr = {5,2,6,3};
        int[] arr1 = {1,4};
        System.out.println(maxArea(h, w, arr, arr1));

    }
}
