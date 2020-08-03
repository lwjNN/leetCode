package com.leetcode.everyday.july;

import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * 返回的长度需要从小到大排列。
 * 示例：
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/7/8 11:01
 */
public class Solution_16_11 {
    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if(longer == shorter){
            return new int[]{k};
        }
        int[] arr = new int[k + 1];
        arr[0] = shorter * k;
        for (int i = 1; i <= k; i++) {
            arr[i] = arr[i - 1] + longer - shorter;
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] ints = divingBoard(1, 1, 100000);
//        System.out.println(Arrays.toString(ints));

        String oneReserveOne = "[\"76\",\"77\"]";
        oneReserveOne = oneReserveOne.replace("[","").replace("]","").replaceAll("\"","");
        System.out.println(oneReserveOne);
    }
}
