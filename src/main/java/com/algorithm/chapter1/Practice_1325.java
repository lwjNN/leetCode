package com.algorithm.chapter1;

public class Practice_1325 {
    public static class Node {
        Node next;
        String item;
    }

    public static Node append(Node list, String item) {
        Node oldList = list;
        list = new Node();
        list.item = item;
        list.next = oldList;
        return list;
    }

    public static Node insertAfter(Node first, Node second) {
        if (first == null && second == null) {
            return null;
        }
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        Node connect = first.next;
        first.next = second;
        Node currentNode = first;
        while (currentNode.next.item != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = connect;
        return first;

    }


    public static void main(String[] args) {
        Node node1 = new Node();
        node1 = append(node1, "app1");
        node1 = append(node1, "app2");
        node1 = append(node1, "app3");

        Node node2 = new Node();
        node2 = append(node2, "bbq1");
        node2 = append(node2, "bbq2");
        node2 = append(node2, "bbq3");

        Node node = insertAfter(node1, node2);
        while (node.next != null) {
            System.out.println(node.item);
            node = node.next;
        }
    }
}
