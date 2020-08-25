package com.leetcode.week;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lwj
 * @date 2020/8/23 10:28
 */
public class Solution_0823_1 {
    public static List<Integer> mostVisited(int n, int[] rounds) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, 0);
        }
        map.put(rounds[0], 1);
        for (int i = 0; i < rounds.length - 1; i++) {
            if (rounds[i + 1] > rounds[i]) {
                for (int j = rounds[i] + 1; j <= rounds[i + 1]; j++) {
                    map.put(j, map.get(j) + 1);
                }
            } else {
                int i1 = rounds[i + 1] + n;
                for (int j = rounds[i] + 1; j <= i1; j++) {
                    int i2 = j % n == 0 ? n : j % n;
                    map.put(i2, map.get(i2) + 1);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        map.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toList());
        int max = 0;
        for (Integer key: map.keySet()) {
            max = Math.max(map.get(key), max);
        }
        for (Integer key: map.keySet()) {
            if(map.get(key) == max){
                list.add(key);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> integers = mostVisited(2, new int[]{2,1,2,1,2,1,2});
    }
}
