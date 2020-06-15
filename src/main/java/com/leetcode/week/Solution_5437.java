package com.leetcode.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 193场周赛~解出两道~~继续努力吧
 * @author LWJ
 * @date 2020/6/14 10:27
 */
public class Solution_5437 {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        int[] tmp = new int[map.size()];
        Set<Integer> integers = map.keySet();
        int index = 0;
        for (Integer i : integers) {
            tmp[index++] = map.get(i);
        }
        Arrays.sort(tmp);
        if(k<tmp[0]){
            return tmp.length;
        }
        int len = tmp.length;

        int sum = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            sum += tmp[i];
            if (k < sum) {
                res = len - i;
                break;
            } else if (k == sum) {
                res = len - i - 1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        System.out.println(findLeastNumOfUniqueInts(arr, 1));
    }
}
