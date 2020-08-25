package com.leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lwj
 * @date 2020/8/25 11:49
 */
public class Solution_559 {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        if(root.children == null || root.children.size() == 0){
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        for (Node node:root.children) {
            list.add(maxDepth(node));
        }
        return Collections.max(list) + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
