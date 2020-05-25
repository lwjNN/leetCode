package com.algorithm.tree;

/**
 * 红黑树实现
 * @author LWJ
 * @date 2020/5/17 8:47
 */
public class RedBlackTree {
    private final int R = 0;
    private final int B = 1;

    private int data;
    private Node root;

    class Node{
        int color = R;
        private int data;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    public void leftRotate(Node node){
        //第一种情况、父节点为空。直接左旋。原根节点的右节点作为新的根节点，
        // 原根节点作为新根节点的左子节点，新根节点的左子节点变为原跟节点的右子节点
        if (node.parent == null){
            //定义right为原根节点的右子节点
            Node right = root.right;
            //将原根节点的右子节点指向原right的左节点
            root.right = right.left;
            //同样将right的左子节点的父节点指向root。
            right.left.parent = root;
            //将原根节点的父节点指向right节点。
            root.parent = right;
            //定义新的根节点
            right.parent = null;
            //root指向新的根节点
            root = right;
        }
    }

}
