package com.leetcode.week;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2020-11-15周赛第一题
 * @author lwj
 * @date 2020/11/15 10:36
 */
public class OrderedStream {
    Map<Integer, String> map = new HashMap<>();
    int pre = 1;

    public OrderedStream(int n) {

    }

    public List<String> insert(int id, String value) {
        List<String> res = new ArrayList<>();
        if (map.size() == 0 && id != 1) {
            map.put(id, value);
            return res;
        }
        if (pre == id) {
            map.put(id, value);
            for (int i = pre; i <= map.size(); i++) {
                if(map.get(i) == null){
                    break;
                }else{
                    res.add(map.get(i));
                    pre = i+1;
                }
            }
        }else{
            map.put(id, value);
        }
        return res;
    }

    public static void main(String[] args) {
        OrderedStream s = new OrderedStream(5);
        System.out.println(s.insert(3, "cccc"));
        System.out.println(s.insert(1, "aaaa"));
        System.out.println(s.insert(2, "bbbb"));
        System.out.println(s.insert(5, "eeee"));
        System.out.println(s.insert(4, "dddd"));
    }
}
