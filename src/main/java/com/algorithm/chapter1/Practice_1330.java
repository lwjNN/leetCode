package com.algorithm.chapter1;

/**
 * 翻转链表
 */
public class Practice_1330 {

    public static class Node {
        Node next;
        String item;
    }

    public static Node reverse(Node x){
        if (x == null || x.next == null){
            return x;
        }
        Node newNode = null;
        Node first = x;
        while (first != null){
            Node second = first.next;
            first.next = newNode;
            newNode = first;
            first = second;
        }
        return newNode;
    }

    public static void main(String[] args) {
        Node x = new Node();
        x.item = "a";
        x.next = new Node();
        x.next.item = "b";
        x.next.next = new Node();
        x.next.next.item = "c";

        Node reverse = reverse(x);
        while (reverse != null){
            System.out.print (reverse.item + " ");
            reverse = reverse.next;
        }
    }
}
