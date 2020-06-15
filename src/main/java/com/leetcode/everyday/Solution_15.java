package com.leetcode.everyday;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author LWJ
 * @date 2020/6/12 9:38
 */
public class Solution_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int tar = 0 - nums[i];
            Set<List> ints = twoSum(Arrays.copyOfRange(nums, i+1, nums.length), tar);
            if(ints.size()>0){
                for (List l:ints) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.addAll(l);
                    resList.add(list);
                }
            }



        }
        return resList;
    }

    public static Set<List> twoSum(int[] arr, int target) {
        Set<List> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Arrays.stream(arr).forEach(s->{
            set1.add(s);
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num :set1) {
            int complement = target - num;
            if(map.containsKey(complement)){
                List<Integer> list = new ArrayList<>();
                list.add(complement);
                list.add(num);
                set.add(list);
            }
            map.put(num, num);
        }
        return set;
    }

    public static void main(String[] args) {
//        -1, 0, 1, 2, -1, -4,
        int[] arr = {4,-2,-2};
//        System.out.println(Arrays.toString(arr));
        List<List<Integer>> lists = threeSum(arr);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

}
