package com.leetcode.arrays;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 15600
 */
public class mergeTowSortedLinked_88 {

    /**
     * 正向双指针
     * 时间复杂度。O（m+n）
     * 空间复杂度 O(m)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge_twoPoints(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++]);
        }
        //如果p1小于m，说明p2数组已经遍历完毕，只需要把p1剩下元素放在nums1中即可
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p2 + p1, m - p1);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p2 + p1, n - p2);
        }
        System.out.println(Arrays.toString(nums1));

    }

    /**
     * 双指针倒序
     * 时间复杂度O(m+m)
     * 空间复杂度O(1)
     *
     * @param num1
     * @param m
     * @param num2
     * @param n
     */
    public static void merge_reverseTwoPoints(int[] num1, int m, int[] num2, int n) {
        if (m == 0) {
            num1 = num2;
        }
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            num1[p--] = (num1[p1] > num2[p2] ? num1[p1--] : num2[p2--]);
        }
        if (p2 > 0) {
            System.arraycopy(num2, 0, num1, 0, p2 - 1);
        }

        System.out.println("2***" + Arrays.toString(num1));
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 8, 9, 0, 0, 0};
        int[] arr2 = {2, 5, 6};
        merge_twoPoints(arr1, 3, arr2, 3);
        int[] arr3 = {0};
        int[] arr4 = {1};
        merge_reverseTwoPoints(arr3, 0, arr4, 1);
//        System.arraycopy(arr2,1,arr1,3,2);
    }
}
