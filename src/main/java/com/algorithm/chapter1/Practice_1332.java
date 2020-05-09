package com.algorithm.chapter1;

/**
 * 双向链表api
 */
public class Practice_1332<Item> {

    private int N;
    private Node first;
    private Node last;

    public class Node<Item> {
        Node next;
        Node forward;
        Item item;
    }

    public boolean isEmply() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public <Item> void push(Item item) {
        Node node = new Node<>();
        node.item = item;
        if (size() == 0) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first = node;
        }
        N++;
    }

    public Item pop() {
        if (isEmply()) {
            System.out.println("空栈");
            return null;
        }
        Node oldFirst = first;
        if (size() == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            oldFirst.next = null;
        }
        N--;
        return (Item) oldFirst.item;
    }

    public void enqueue(Item item) {
        Node newLast = new Node();
        newLast.item = item;
        if (isEmply()) {
            first = newLast;
            last = newLast;
        } else {
            last.next = newLast;
            last = newLast;
        }
        N++;
    }

}
