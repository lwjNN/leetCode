package com.leetcode.sword2offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/5/18 17:45
 */
public class Solution_04 {


    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;//行数
        if(n == 0){
            return false;
        }
        int m = matrix[0].length; //列数
        if(m == 0){
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] > target) {
                return false;
            }
            if(matrix[i][m-1] < target){
                continue;
            }
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == target){
                    return true;
                }else{
                    continue;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] arr = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},{10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] arr = {{}};
        boolean boo = findNumberIn2DArray(arr, 24);
        System.out.println(boo);
    }

}
