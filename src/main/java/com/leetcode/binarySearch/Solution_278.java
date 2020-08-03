package com.leetcode.binarySearch;

/**
 * @author LWJ
 * @date 2020/7/27 10:30
 */
public class Solution_278 extends VersionControl {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

abstract class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }

    ;
}
