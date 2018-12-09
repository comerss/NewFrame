package com.donews.frame.camera;

/**
 * Created by Comers on 2018/12/9.
 * 描述：
 */
public class Reverse {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//       reverse(node1);
        System.out.print(reverse2(node1));
    }

    public static Node reverse(Node node) {
        if (node.next == null) {
            return node;
        }
        Node temp = null;
        Node next;
        while (node != null) {
            next = node.next;
            node.next = temp;

            temp = node;
            node = next;
            System.out.println("temp--->" + temp);
            System.out.println("node--->" + node);
        }
        return temp;
    }

    public static Node reverse2(Node node) {
        if (node.next == null) {
            return node;
        }
        Node pre = reverse2(node.next);

        Node temp = node.next;
        temp.next=node;
        node.next=null;
        System.out.println("pre--->" + pre);
        return pre;

    }

    public static class Node {
        public Node(int data) {
            this.data = data;
        }

        int data;
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
