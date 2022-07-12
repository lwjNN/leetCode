package com.leetcode.week;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给你一个二维整数数组 circles ，其中 circles[i] = [xi, yi, ri] 表示网格上圆心为 (xi, yi) 且半径为 ri 的第 i 个圆，返回出现在 至少一个 圆内的 格点数目 。
 *
 * 注意：
 *
 * 格点 是指整数坐标对应的点。
 * 圆周上的点 也被视为出现在圆内的点。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：circles = [[2,2,1]]
 * 输出：5
 * 解释：
 * 给定的圆如上图所示。
 * 出现在圆内的格点为 (1, 2)、(2, 1)、(2, 2)、(2, 3) 和 (3, 2)，在图中用绿色标识。
 * 像 (1, 1) 和 (1, 3) 这样用红色标识的点，并未出现在圆内。
 * 因此，出现在至少一个圆内的格点数目是 5 。
 * 示例 2：
 *
 *
 *
 * 输入：circles = [[2,2,2],[3,4,1]]
 * 输出：16
 * 解释：
 * 给定的圆如上图所示。
 * 共有 16 个格点出现在至少一个圆内。
 * 其中部分点的坐标是 (0, 2)、(2, 0)、(2, 4)、(3, 2) 和 (4, 4) 。
 * @author lwj
 * @date 2022/4/24 10:27
 */
public class Solution_0424_2 {
    public int countLatticePoints(int[][] circles) {
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < circles.length; i++) {
            helper(circles[i], set);
        }
        System.out.println(set.size());
        return set.size();
    }

    public void helper(int[] arr, Set<int[]> set){
        for (int i = 0; i <= arr[0] + arr[2]; i++) {
            for (int j = 0; j <= arr[1] + arr[2]; j++) {
                if ((i - arr[0]) * (i - arr[0]) + (j - arr[1]) * (j - arr[1]) <= (arr[2] * arr[2])){
                    int[] aa = {arr[0], arr[1]};
                    set.add(aa);
                }
            }
        }

    }

    public static void main(String[] args) {
        Solution_0424_2 s = new Solution_0424_2();
        int a[][]={{2,2,2},{3,4,1}};
        s.countLatticePoints(a);
    }
}
