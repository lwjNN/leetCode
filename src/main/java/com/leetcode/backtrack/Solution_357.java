package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * 示例:
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/11/4 9:36
 */
public class Solution_357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 1){
            return 10;
        }
        int res = 10, k = 9, tmp = 9;
        for (int i = 2; i <= Math.min(n, 10); i++) {
            tmp *= k;
            k--;
            res += tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_357 s = new Solution_357();
        System.out.println(s.countNumbersWithUniqueDigits(3));
    }
}
