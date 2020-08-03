package com.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/7/14 21:14
 */
public class Solution_169 {

    /**
     * 1.排序，中间元素即为结果
     * 时间复杂度nlogn
     *
     * @param nums
     * @return
     */
    public int majorityElement_1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 哈希表 ，
     *
     * @param nums
     * @return
     */
    public static int majorityElement_2(int[] nums) {
        int majorityElement = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > nums.length / 2) {
                majorityElement = integer;
            }
        }
        return majorityElement;
    }

    /**
     * 摩尔投票算法
     *
     * @param nums
     * @return
     */
    public static int majorityElement_3(int[] nums) {
        int counter = 0;
        Integer res = null;
        for (int num : nums) {
            if (counter == 0) {
                res = num;
            }
            counter += (num == res) ? 1 : -1;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement_3(arr));
    }
}
