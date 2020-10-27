package com.leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lwj
 * @date 2020/8/31 17:05
 */
public class Solution_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        //将0下标放入set
        set.add(0);
        helper(rooms, rooms.get(0), set);
        //如果最终set集合元素中个数和rooms元素个数相同，说明所有房间都遍历到了。证明所有房间都可以进入。返回true
        if (set.size() == rooms.size()) {
            return true;
        }
        return false;
    }
    public void helper(List<List<Integer>> rooms, List<Integer> room, Set<Integer> set) {
        for (Integer i : room) {
            //如果set中包含了该房间号，继续遍历
            if (set.contains(i)) {
                continue;
            } else {
                //如果不包含，将该房间号添加进去，并且递归查询该房间号对应的房间号列表
                set.add(i);
                helper(rooms, rooms.get(i), set);
            }
        }
    }

    public static void main(String[] args) {
        Solution_841 s = new Solution_841();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1= new ArrayList<>();
        list1.add(1);
        list1.add(3);
        List<Integer> list2= new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        List<Integer> list3= new ArrayList<>();
        list3.add(2);
        List<Integer> list4= new ArrayList<>();
        list4.add(0);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        System.out.println(s.canVisitAllRooms(list));
    }

}
