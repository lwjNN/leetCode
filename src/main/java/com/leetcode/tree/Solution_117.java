package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lwj
 * @date 2020/9/28 9:36
 */
public class Solution_117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Deque<Node> deque = new ArrayDeque<>();
        Deque<Node> help = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.removeFirst();
                if(deque.isEmpty()){
                    node.next = null;
                }else{
                    node.next = new Node(deque.peek().val);
                }
                help.addLast(node);
            }
            int size1 = help.size();
            for (int i = 0; i < size1; i++) {
                Node node = help.removeFirst();
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static void main(String[] args) {
        Solution_117 s = new Solution_117();
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);
        s.connect(root);
    }
};
