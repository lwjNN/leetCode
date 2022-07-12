package com.leetcode.restart;

import java.util.TreeSet;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 * <p>
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2022/7/1 17:29
 */
public class Solution414 {
    public static int thirdMax(int[] nums) {
        if (nums.length < 1){
            return 0;
        }
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > first){
                third = second;
                second = first;
                first = (int)num;
            }
            if (num < first && num > second) {
                third = second;
                second = num;
            }
            if (num < second && num > third){
                third = num;
            }
        }
        return third == Long.MIN_VALUE ? (int)first: (int)third;
    }

    public static int thirdMax2(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums){
            treeSet.add(num);
            if (treeSet.size() > 3){
                treeSet.remove(treeSet.first());
            }
        }
        return treeSet.size() == 3 ? treeSet.first():treeSet.last();
    }

    public static void main(String[] args) {
        System.out.println(thirdMax2(new int[]{2, 2, 3, 1, 4, 5, 2}));
    }
}
