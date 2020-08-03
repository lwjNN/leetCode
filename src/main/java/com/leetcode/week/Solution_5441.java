package com.leetcode.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LWJ
 * @date 2020/6/21 10:37
 */
public class Solution_5441 {
    public static String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (map.get(names[i]) == null) {
                res[i] = names[i];
                map.put(names[i], 1);
            } else {
                for (int j = 1; j <= map.size(); j++) {
                    if (map.get(names[i] + "(" + j + ")") == null) {
                        res[i] = names[i] + "(" + j + ")";
                        break;
                    } else {
                        res[i] = names[i] + "(" + (j + 1) + ")";
                    }
                }
                map.put(res[i], map.get(names[i]) + 1);
            }
        }

        return res;
    }

    public static String[] getFolderNames_1(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (names[i].indexOf("(") == -1 && map.get(names[i]) == null) {
                map.put(names[i], 1);
                res[i] = names[i];
            } else if (names[i].indexOf("(") > -1 && map.get(names[i]) == null) {
                int i1 = names[i].indexOf("(") + 1;
                int i2 = names[i].indexOf(")") ;
                int i3 = Integer.parseInt(names[i].substring(i1, i2));
                map.put(names[i],i3);
                if(i3!=0){
                    String sub = names[i].substring(0, names[i].indexOf("("));
                    map.put(sub,(map.get(sub)==null?0:map.get(sub))+1);
                }
                res[i] = names[i];
            }
            else if(names[i].indexOf("(") == -1 && map.get(names[i]) != null){
                res[i] = names[i] + "(" + map.get(names[i]) + ")";
                map.put(names[i],map.get(names[i]) +1);
                map.put(res[i],(map.get(res[i])==null?0:map.get(res[i])) +1);
            }else if(names[i].indexOf("(") != -1 && map.get(names[i]) != null){
                res[i] = names[i] + "(" + map.get(names[i]) + ")";
                map.put(names[i],map.get(names[i])+1);
                map.put(res[i],(map.get(res[i])==null?0:map.get(res[i])) +1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] names1 = {"wano","wano","wano","wano"};
        String[] names = {"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
        String[] names2 = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
        String[] names3 = {"kingston(0)","kingston","kingston"};
        String[] folderNames = getFolderNames_1(names3);
        System.out.println(Arrays.toString(folderNames));
    }
}
