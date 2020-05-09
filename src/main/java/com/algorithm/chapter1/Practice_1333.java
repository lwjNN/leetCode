package com.algorithm.chapter1;

import java.util.Iterator;

/**
 * Deque 双向队列，同时支持两端添加或删除元素
 */
public class Practice_1333<Item> implements Iterable<Item> {

    private int N;
    private Node left;
    private Node right;

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public class Node<Item> {
        private Node<Item> previous;
        private Item item;
        private Node<Item> subsequent;

        public Node() {
            previous = null;
            subsequent = null;
        }
    }

    public boolean isEmply() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    void pushLeft(Item item) {
        Node oldLeft = left;
        left = new Node();
        left.item = item;
        if (isEmply()) {
            left.subsequent = oldLeft;
            left.previous = oldLeft;
            right = left;
        } else {
            left.subsequent = oldLeft;
            oldLeft.previous = left;
        }
        N++;
    }

    void pushRight(Item item) {
        Node oldRight = right;
        right = new Node();
        right.item = item;
        if (isEmply()) {
            right.subsequent = oldRight;
            right.previous = oldRight;
            left = right;
        } else {
            right.previous = oldRight;
            oldRight.subsequent = right;
        }
        N++;
    }

    public Item popLeft() {
        if (isEmply()) {
            return null;
        }
        Item item = (Item) left.item;
        left = left.subsequent;
        left.previous = null;
        N--;
        return item;
    }

    public Item popRight(){
        if (isEmply()){
            return null;
        }

        Item item = (Item) right.item;
        right = right.previous;
        right.subsequent = null;
        N--;
        return item;
    }


}
