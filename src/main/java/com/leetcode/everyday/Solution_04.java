package com.leetcode.everyday;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/5/24 10:07
 */
public class Solution_04 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int length1 = nums2.length;
        int[] newArr = new int[length + length1];
        if (length == 0) {
            if (length1 % 2 == 0) {
                return (nums2[length1 / 2 - 1] + nums2[length1 / 2]) / 2.0;
            } else {
                return nums2[length1 / 2];
            }
        }
        if (length1 == 0) {
            if (length % 2 == 0) {
                return (nums1[length / 2 - 1] + nums1[length / 2]) / 2.0;
            } else {
                return nums1[length / 2];
            }
        }
        int count = 0;
        int i = 0, j = 0;
        while (count != (length + length1)) {
            if (i == length) {
                while (j != length1) {
                    newArr[count++] = nums2[j++];
                }
                break;
            }
            if (j == length1) {
                while (i != length) {
                    newArr[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                newArr[count++] = nums1[i++];
            } else {
                newArr[count++] = nums2[j++];
            }
        }
        if(count %2 ==  0){
            return (newArr[count / 2 - 1] + newArr[count / 2]) / 2.0;
        }else{
            return newArr[count / 2];
        }

//        double res1 = 0, res2 = 0;
//        if(length == 1){
//            res1 = nums1[0];
//        }else if (length != 0 & length % 2 == 0) {
//            res1 = (nums1[length / 2 -1] + nums1[length / 2 ]) / 2.0;
//        } else if (length != 0 & length % 2 == 1) {
//            res1 = nums1[length / 2 -1];
//        }
//        if(length1 == 1){
//            res2 = nums2[0];
//        }else if (length1 != 0 & length1 % 2 == 0) {
//            res2 = (nums2[length1 / 2 -1] + nums2[length1 / 2 ]) / 2.0;
//        } else if (length1 != 0 & length1 % 2 == 1) {
//            res2 = nums2[length1 / 2] ;
//        }
//        return (res1 + res2)/2.0;
    }

    public static double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {0, 0, 0};
        int[] nums2 = {1, 3, 5};
        System.out.println(findMedianSortedArrays1(nums1, nums2));
    }

}
