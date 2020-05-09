package com.algorithm.chapter1;

public class Practice_1327 {
    public static class Node {
        Node next;
        int item;

        Node(int i){
            this.item = i;
        };
    }

    public static int max(Node list){
        if(list == null){
            return 0;
        }
        int max = 0;
        for (Node x = list; x != null ; x = x.next) {
            if(max < x.item){
                max = x.item;
            }
        }
        return max;
    }

    public static int max_recursion(Node list){
        if(list == null){
            return 0;
        }
        return Math.max(list.item,max_recursion(list.next));
    }

    public static void main(String[] args) {
        Node first = new Node(12);
        first.next = new Node(5);
        first.next.next = new Node(111);
        first.next.next.next = new Node(99);
        int max = max_recursion(first);
        System.out.println(max);
    }


}
