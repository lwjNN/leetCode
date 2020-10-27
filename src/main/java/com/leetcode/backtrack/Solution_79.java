package com.leetcode.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/9/29 13:57
 */
public class Solution_79 {
    int lenght, height;

    public boolean exist(char[][] board, String word) {
        lenght = board.length;
        height = board[0].length;
        boolean[][] used = new boolean[lenght][height];
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean ans = helper(board, used, word, i, j, 0);
                    if (ans) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, boolean[][] used, String word, int i, int j, int index) {
        if (i >= lenght || i < 0 || j >= height || j < 0 || board[i][j] != word.charAt(index) || used[i][j] ) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        boolean res = false;
        if (!used[i][j]) {
            used[i][j] = true;
            res = helper(board, used, word, i + 1, j, index + 1) ||
                    helper(board, used, word, i - 1, j, index + 1) ||
                    helper(board, used, word, i, j + 1, index + 1) ||
                    helper(board, used, word, i, j - 1, index + 1);
        }
        used[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        Solution_79 s = new Solution_79();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(board);
        System.out.println(s.exist(board, "ABCB"));
    }
}
