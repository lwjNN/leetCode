package com.leetcode.sword2offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/5/27 11:15
 */
public class Solution_21 {

    public static int[] exchange(int[] nums) {
        int len = nums.length - 1;
        int preIndex = 0;
        int lastIndex = len;
        int[] newNums = new int[nums.length];
        for (int i = 0; i <= len; i++) {
            if ((nums[i] & 1) == 1) {
                //奇数放前边
                newNums[preIndex++] = nums[i];
            } else {
                newNums[lastIndex--] = nums[i];
            }
        }
        return newNums;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int[] exchange = exchange(nums);
        System.out.println(Arrays.toString(exchange));
    }
}
