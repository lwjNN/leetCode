package com.leetcode.binarySearch;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/7/28 9:15
 */
public class Solution_349 {
    /**
     * 哈希表方法 时间复杂度O(n) ,空间复杂度O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection_1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            if (map.get(num) == null) {
                map.put(num,1);
            }
        }
        for (int num:nums2) {
            if(map.get(num)!=null){
                set.add(num);
            }
        }
        int[] arr = new int[set.size()];
        int index = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            arr[index++] = iterator.next();
        }
        return arr;
    }

    /**
     * 排序加双指针（超时了~应该是必须线性时间复杂度才能过）
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection_2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pointer1 = 0;
        int pointer2 = 0;
        Set<Integer> set = new HashSet<>();
        for (; pointer1 < nums1.length&&pointer2 < nums2.length;) {
            if(nums1[pointer1]<nums2[pointer2]){
                pointer1++;
            }else if(nums1[pointer1]>nums2[pointer2]){
                pointer2++;
            }else{
                set.add(nums1[pointer1]);
            }
        }
        int[] arr = new int[set.size()];
        int index = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            arr[index++] = iterator.next();
        }
        return arr;
    }

}
