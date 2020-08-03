package com.leetcode.arrays;

import java.util.Arrays;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/7/10 9:19
 */
public class Solution_121 {
    //暴力法
    public static int maxProfit(int[] prices) {
        int maxRes = 0;
        for (int i = prices.length - 1; i > 0; i--) {
            int[] ints = Arrays.copyOfRange(prices, 0, i);
            int min = getMin(ints);
            if(min>=prices[i]){
                continue;
            }
            maxRes = Math.max(prices[i]-min,maxRes);

        }
        return maxRes;
    }

    public static int getMin(int[] source) {
        int min = source[0];
        for (int i = 1; i < source.length; i++) {
            if (min > source[i]) {
                min = source[i];
            }
        }
        return min;
    }

    //单次循环，查找最小值以及最大差值
    public static int maxProfit_1(int[] prices){
        int minprofit = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<minprofit){
                minprofit = prices[i];
            }else if(prices[i]-minprofit>maxProfit){
                maxProfit = prices[i]-minprofit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,2,8,7};
        System.out.println(maxProfit_1(arr));
    }
}
