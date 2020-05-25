package com.algorithm.tree;

/**
 * @author lwj
 */
public class BinarySearchTree {

    int data;
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void insert(BinarySearchTree root, int data) {
        if (root.data < data) {
            //如果根节点的值小于要插入的值，往右子树方向找
            if (root.right == null) {
                //如果根节点右子树没有值，直接new一个右子树
                root.right = new BinarySearchTree(data);
            } else {
                //有值就递归查询右子树
                insert(root.right,data);
            }
        }else{
            //左子树插入
            if(root.left == null){
                root.left = new BinarySearchTree(data);
            }else{
                insert(root.left, data);
            }
        }
    }

    /**
     * 中序查找(左根右)
     */
    public void in(BinarySearchTree root){
        if(root != null){
            in(root.left);
            System.out.print(root.data + " ");
            in(root.right);
        }
    }


    public static void main(String[] args) {
        int[] arr = {5,6,3,7,1,9,2};
        BinarySearchTree bst = new BinarySearchTree(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            bst.insert(bst,arr[i]);
        }
        bst.in(bst);
    }


}
