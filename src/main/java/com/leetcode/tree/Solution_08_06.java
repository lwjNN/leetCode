package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * 你需要原地修改栈。
 * 示例1:
 * <p>
 * 输入：A = [2, 1, 0], B = [], C = []
 * 输出：C = [2, 1, 0]
 * 示例2:
 * <p>
 * 输入：A = [1, 0], B = [], C = []
 * 输出：C = [1, 0]
 * 提示:
 * <p>
 * A中盘子的数目不大于14个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hanota-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/9/24 11:09
 */
public class Solution_08_06 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        System.out.println("刚开始：" + A);
        System.out.println("刚开始：" + C);
        int size = A.size();
        move(size, A, B, C);
        System.out.println("后来->" + A);
        System.out.println("后来->" + C);
    }

    public void move(int index, List<Integer> original, List<Integer> auxiliary, List<Integer> target) {
        if (index == 1) {
            target.add(original.remove(original.size()-1));
            return;
        }
        move(index - 1, original, target, auxiliary);
        target.add(original.remove(original.size() - 1));
        move(index - 1, auxiliary, original, target);
    }

    public static void main(String[] args) {
        Solution_08_06 s = new Solution_08_06();
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        s.hanota(A, B, C);
    }
}
