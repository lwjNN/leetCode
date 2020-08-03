package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/7/6 23:22
 */
public class Solution_118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<>();
        if (numRows == 0) {
            return resList;
        }
        resList.add(new ArrayList<>());
        resList.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> preList = resList.get(i - 1);//上一层
            for (int j = 1; j < i; j++) {
                list.add(preList.get(j - 1) + preList.get(j));
            }
            list.add(1);
            resList.add(list);
        }
        return resList;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        for (int i = 0; i < generate.size(); i++) {
            System.out.println(generate.get(i));
        }

//        List<Integer> list = new ArrayList<>(6);
//        int[] arr = new int[10];
//        System.out.println(list.size());
//        System.out.println(arr.length);
    }
}
