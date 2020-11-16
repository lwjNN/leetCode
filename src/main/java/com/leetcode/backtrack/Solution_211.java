//package com.leetcode.backtrack;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author lwj
// * @date 2020/10/30 17:28
// */
//public class Solution_211 {
//
//    private final int SIZE = 26;  //每个节点能包含的子节点数，即需要SIZE个指针来指向其孩子
//    private Node root;   //字典树的根节点
//
//    public Solution_211() {
//        root = new Node();
//    }
//
//    public void addWord(String word) {
//        if(word == null || word.isEmpty()){
//            return;
//        }
//        Node pNode = this.root;
//        for (int i = 0; i < word.length(); i++) {
//            int index = word.charAt(i) - 'a';
//            if(pNode.child[index] == null){
//                Node tmpNode = new Node();
//                pNode.child[index] = tmpNode;
//            }else{
//                pNode.child[index].num++;
//            }
//        }
//        pNode.isStr = true;
//    }
//
//    public boolean search(String word) {
//
//        return false;
//    }
//
//    class Node{
//        private boolean isStr;
//        private int num;
//        private Node[] child;
//
//        public Node() {
//            isStr = false;
//            num = 1;
//            child = new Node[SIZE];
//        }
//    }
//
//}
