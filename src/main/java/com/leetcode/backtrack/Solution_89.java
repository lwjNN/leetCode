package com.leetcode.backtrack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * 格雷编码序列必须以 0 开头。
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 *      给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 *      因此，当 n = 0 时，其格雷编码序列为 [0]。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gray-code
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/10/28 11:29
 */
public class Solution_89 {
    public Map<Integer, String> map = new HashMap<Integer, String>() {{
        put(0, "0");
        put(1, "1");
    }};

    public List<Integer> grayCode(int n) {
        List<Integer> resList = new ArrayList<>();
        if (n == 0) {
            resList.add(0);
            return resList;
        }
        if (n == 1) {
            resList.add(0);
            resList.add(1);
            return resList;
        }
        StringBuilder sb = new StringBuilder();
        Set<String> strList = new HashSet<>();
        backtrack(n, 0, strList, "");
        Object[] array = strList.stream().sorted().toArray();
        System.out.println(array);
        for (Object s : array) {
            resList.add(Integer.valueOf((String) s, 2));
        }
        return resList;
    }

    private void backtrack(int n, int index, Set<String> strList, String str) {
        if (str.length() == n) {
            strList.add(str);
            return;
        }
        for (int i = 0; i < n; i++) {
            backtrack(n, i + 1, strList, str + map.get(i % 2));
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("1111101", 2).toString());
        Solution_89 s = new Solution_89();
        System.out.println(s.grayCode(2));
    }
}
