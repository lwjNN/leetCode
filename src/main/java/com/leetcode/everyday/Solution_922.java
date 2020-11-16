package com.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lwj
 * @date 2020/11/12 18:17
 */
public class Solution_922 {
    public static int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        int[] res = new int[length];
        Deque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < length; i++) {
            if(A[i]%2==0){
                deque.addFirst(A[i]);
            }else {
                deque.addLast(A[i]);
            }
        }
        for (int i = 0; i < length; i++) {
            if(i%2==0){
                res[i] = deque.removeFirst();
            }else{
                res[i] = deque.removeLast();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }
}
