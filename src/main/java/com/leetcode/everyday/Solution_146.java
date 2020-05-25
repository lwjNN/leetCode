package com.leetcode.everyday;

import java.util.*;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 示例:
 * LRUCache cache = new LRUCache( 2 ： 缓存容量  );
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LWJ
 * @date 2020/5/25 9:15
 */
public class Solution_146 {

    private Map<Integer, Integer> map;
    Deque<Integer> deque ;
    Stack <Integer> stack ;
    private int capacity;

    public Solution_146(int capacity) {
        map = new HashMap<>(capacity);
        deque = new ArrayDeque<>(capacity);
        stack = new Stack<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        put(key,map.get(key));
        return map.get(key);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, value);
            while (deque.peek() != key){
                stack.push(deque.poll());
            }
            deque.offer(deque.poll());
            while (!stack.isEmpty()){
                deque.offerFirst(stack.pop());
            }
        }else {
            if (map.size() < capacity) {
                map.put(key, value);
                deque.offer(key);
            } else {
                map.remove(deque.poll());
                map.put(key, value);
                deque.offer(key);
            }
        }
    }

    public static void main(String[] args) {
        Solution_146 so = new Solution_146(2);
        so.put(2,1);
        so.put(3,2);
        System.out.println(so.get(3));
        so.put(3,3);
        System.out.println(so.get(2));
        so.put(4,3);
        System.out.println(so.get(2));
        System.out.println(so.get(3));
        System.out.println(so.get(4));
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.addFirst(0);
//        deque.addFirst(1);
//        System.out.println(deque.peek());
    }

}
