package com.leetcode.dfs_bfs;

/**
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * 最后返回经过上色渲染后的图像。
 * 示例 1:
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 * 注意:
 * <p>
 * image 和 image[0] 的长度在范围 [1, 50] 内。
 * 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
 * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/8/27 9:37
 */
public class Solution_733 {
    int srLen, sclen = 0;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        srLen = image.length;
        sclen = image[0].length;
        if(image[sr][sc] == newColor){
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int tarColor, int newColor) {
        if (sr >= srLen || sr < 0 || sc >= sclen || sc < 0 || image[sr][sc] != tarColor) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, tarColor, newColor);
        dfs(image, sr - 1, sc, tarColor, newColor);
        dfs(image, sr, sc + 1, tarColor, newColor);
        dfs(image, sr, sc - 1, tarColor, newColor);
    }
}
