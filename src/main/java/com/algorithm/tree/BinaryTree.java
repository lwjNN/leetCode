package com.algorithm.tree;

/**
 * 二叉树三种遍历方式
 * @author LWJ
 * @date 2020/5/17 16:17
 */
public class BinaryTree {

    public static void main(String[] args) {
        BNode D = new BNode('D',null, null);
        BNode H = new BNode('H',null, null);
        BNode K = new BNode('K',null, null);
        BNode C = new BNode('C',D, null);
        BNode B = new BNode('B',null, C);
        BNode G = new BNode('G', H, K);
        BNode F = new BNode('F', G, null);
        BNode E = new BNode('E', null, F);
        BNode A = new BNode('A', B, E);
        System.out.println("前序--");
        pre(A);
        System.out.println();
        System.out.println("中序--");
        in(A);
        System.out.println();
        System.out.println("后序--");
        back(A);

    }

    /**
     * 前序遍历--根左右
     * @param node
     */
    public static void pre(BNode node){
        print(node);
        if (node.getLeft() != null){
            pre(node.getLeft());
        }
        if (node.getRight() != null){
            pre(node.getRight());
        }
    }

    /**
     * 中序排列--左根右
     * @param node
     */
    public static void in(BNode node){
        if (node.getLeft() != null){
            in(node.getLeft());
        }
        print(node);
        if (node.getRight() != null){
            in(node.getRight());
        }
    }

    /**
     * 后序排列--左右根
     * @param node
     */
    public static void back(BNode node){
        if (node.getLeft() != null){
            back(node.getLeft());
        }
        if (node.getRight() != null){
            back(node.getRight());
        }
        print(node);
    }

    public static void print(BNode node){
        System.out.print(node.getData());
    }
}

/**
 * 二叉树
 */
class BNode{

    private char data;

    private BNode left;
    private BNode right;

    public BNode(char data, BNode left, BNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public BNode getLeft() {
        return left;
    }

    public void setLeft(BNode left) {
        this.left = left;
    }

    public BNode getRight() {
        return right;
    }

    public void setRight(BNode right) {
        this.right = right;
    }
}
