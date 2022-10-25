package com.leetcode.restart;

/**
 * @author lwj
 * @date 2022/7/25 13:05
 */
public class Solution661 {
    public int[][] imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                ans[i][j] =helper(img, i, j);
            }
        }
        return ans;
    }

    public int helper(int[][] img, int i, int j) {
        int ans = 0;
        int index = 1;
        ans += img[i][j];
        if (i > 0) {
            ans += img[i - 1][j];
            index++;
        }
        if (j > 0) {
            ans += img[i][j - 1];
            index++;
        }
        if (i > 0 && j > 0){
            ans += img[i-1][j-1];
            index++;
        }
        if (j<img[0].length -1){
            ans += img[i][j+1];
            index++;
        }
        if (i<img.length -1){
            ans += img[i+1][j];
            index++;
        }
        if (j<img[0].length -1 && i<img.length -1){
            ans+= img[i+1][j+1];
            index++;
        }
        if (i > 0 && j < img[0].length -1){
            ans+= img[i-1][j+1];
            index++;
        }
        if (j > 0 && i < img.length -1){
            ans+= img[i+1][j-1];
            index++;
        }
        return Math.floorDiv(ans, index);
    }
}
