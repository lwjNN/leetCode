package com.leetcode.arrays;

import java.util.TreeSet;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 示例 1:
 * 输入: [3, 2, 1]
 * 输出: 1
 * 解释: 第三大的数是 1
 *
 * 示例 2:
 * 输入: [1, 2]
 * 输出: 2
 * 解释: 第三大的数不存在, 所以返回最大的数 2
 *
 * 示例 3:
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 */
public class ThirdMax {

    /**
     * 常规写法，遍历三次，第一次找到最大的数，第二次找到第二大，第三次找到结果
     * 执行用时1ms。。
     * @param nums
     * @return
     */
    public static int thirdMax1(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }

        int first = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(first < nums[i]){
                //找到最大值，赋值first
                first = nums[i];
            }
        }
        int second = 0;
        boolean b = false;
        for (int i = 0; i < nums.length; i++) {
            //找到第二大元素，同时排除掉重复元素
            if(nums[i]<first){
                if(!b){
                    b = true;
                    second = nums[i];
                }else{
                    second = second > nums[i]?second:nums[i];
                }
            }
        }
        //如果!b成立，说明没走上边循环，意为其他元素都不比first小，全部重复返回最大值。
        if(!b){
            return first;
        }
        int third = 0;
        boolean b1 = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<second){
                if(!b1){
                    b1 = true;
                    third = nums[i];
                }else{
                    third = third >nums[i]?third:nums[i];
                }
            }
        }
        //如果b1赋值为true。那么肯定走第二个循环了。否则就是所有的元素都不小于第二个元素。说明第二大的数都是重复的
        //就返回first.
        if(b1){
            return third;
        }else{
            return first;
        }
    }

    /**
     * 用一个长度为3的treeSet维护，
     *
     * 两次提交记录，一次5ms。一次10ms。比第一种方法要慢
     * @param nums
     * @return
     */
    public static int thirdMax2(int[] nums){
        TreeSet<Integer> tree = new TreeSet();
        for (int i : nums) {
            tree.add(i);
            if(tree.size()>3){
                //如果tree的长度大于3，就把树左边较小的元素删除。
                tree.remove(tree.first());
            }
        }
        return tree.size() == 3? tree.first():tree.last();
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,3,4};
        int i = thirdMax2(nums);
        System.out.println(i);
    }
}
