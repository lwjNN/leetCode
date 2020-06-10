package com.leetcode.sword2offer;

import java.util.*;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * 限制：
 * 1 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/6/2 19:29
 */
public class Solution_39 {
    //数组排序，取数组中间下标值O(nlogn)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    //利用map。时间复杂度O(n)，空间复杂度O(n)
    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        int res= 0;
        for (int i :nums) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (Integer i : map.keySet()) {
            if(map.get(i)>(length/2)){
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,4};
        System.out.println(majorityElement1(arr));
    }
}
