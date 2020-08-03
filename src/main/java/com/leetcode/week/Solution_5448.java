//package com.leetcode.week;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
///**
// * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
// * <p>
// * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
// * <p>
// * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
// * <p>
// * <p>
// * <p>
// * 示例 1：
// * <p>
// * <p>
// * <p>
// * 输入：path = "NES"
// * 输出：false
// * 解释：该路径没有在任何位置相交。
// * 示例 2：
// * <p>
// * <p>
// * <p>
// * 输入：path = "NESWW"
// * 输出：true
// * 解释：该路径经过原点两次。
// * <p>
// * <p>
// * 提示：
// * <p>
// * 1 <= path.length <= 10^4
// * path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
// *
// * @author LWJ
// * @date 2020/6/28 10:33
// */
//public class Solution_5448 {
//    public static boolean isPathCrossing(String path) {
//        Map<int[],Integer> map = new HashMap<>();
//        map.put(new int[]{0,0},1);
//        for (Character c:path.toCharArray()) {
//            int[] arr;
//            if(c == 'E'){
//                arr = new int[]{1, 0};
//                if(map.get(arr) > 0){
//                    return false;
//                }else{
//                    map.put(arr,1);
//                }
//            }else if(c == 'W'){
//                arr = new int[]{-1, 0};
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println(isPathCrossing("ESN"));
//    }
//}
