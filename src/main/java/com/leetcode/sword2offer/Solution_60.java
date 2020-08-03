package com.leetcode.sword2offer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * <p>
 * 限制：
 * 1 <= n <= 11
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/6/20 22:13
 */
public class Solution_60 {
    public static double[] twoSum(int n) {
        if(n == 1){
            double d = getDivide(1,6);
            return new double[]{d, d, d, d, d, d};
        }
        int len = 5 * n + 1;
        double[] res = new double[len];
        int index = 0;
        while (index <= (len / 2)) {
            res[index] = getDivide((index+1), (int) Math.pow(6,n));
            res[len-index-1] = res[index];
            index++;
        }
        return res;
    }

    public static double getDivide(int a, int b){
        double v = (double) a / b;
        String format = String.format("%.6f", v);
        return Double.parseDouble(format);
    }

    public static void main(String[] args) {
        double[] doubles = twoSum(3);
        System.out.println(Arrays.toString(doubles));
    }
}
