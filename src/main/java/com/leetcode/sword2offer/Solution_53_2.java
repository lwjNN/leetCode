package com.leetcode.sword2offer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author LWJ
 * @date 2020/6/3 11:54
 */
//二分 [0,1,2,4,5,6,7,8]
    //[0,1,2,3,5,6,7,8]
public class Solution_53_2 {
    public static int missingNumber(int[] nums) {
        int l = 0,r = nums.length-1;
        while (l<r){
            int mid = (l + r)/2;
            if(l == mid){
                break;
            }
            if(nums[mid]>mid){
                //如果数组中间的值大于中间位置的索引。说明是前半部分有缺失
                r = mid;
            }else{
                //后半部分缺失
                l = mid;
            }
        }
        return nums[l]+1;
    }

    public static void main(String[] args) {
//        int [] arr = {0,1,2,4,5,6,7,8};
//        int [] arr1 = {0,1,2,3,5,6,7,8};
//        System.out.println(missingNumber(arr));
//        System.out.println(missingNumber(arr1));
        System.out.println(1/2);
    }
}
