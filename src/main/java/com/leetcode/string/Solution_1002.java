package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * <p>
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lwj
 * @date 2020/10/14 9:37
 */
public class Solution_1002 {
    public static List<String> commonChars(String[] A) {
        List<String> resList = new ArrayList<>();
        if (A.length == 0) {
            return resList;
        }

        String str = A[0];
        for (int j = 0; j < str.length(); j++) {
            for (int i = 1; i < A.length; i++) {
                if(A[i].substring(j).indexOf(String.valueOf(str.charAt(j)))<0){
                    break;
                }else if(i == A.length -1 && A[i].substring(j).indexOf(String.valueOf(str.charAt(j)))>-1){
                    resList.add(String.valueOf(str.charAt(j)));
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        String[] A = {"bbddabab","cbcddbdd","bbcadcab","dabcacad","cddcacbc","ccbdbcba","cbddaccc","accdcdbb"};
        System.out.println(commonChars(A));
    }
}
