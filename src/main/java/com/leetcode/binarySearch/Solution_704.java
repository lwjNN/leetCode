package com.leetcode.binarySearch;

/**
 * @author lwj
 * @date 2020/8/4 21:53
 */
public class Solution_704 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
