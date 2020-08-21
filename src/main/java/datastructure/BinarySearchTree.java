package datastructure;

import lombok.Getter;

@Getter
public class BinarySearchTree {

    @Getter
    public class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public StringBuilder inOrder(StringBuilder order) {
            if (left != null)
                left.inOrder(order);
            order.append(data).append(",");
            if (right != null)
                right.inOrder(order);

            return order;
        }

        public StringBuilder preOrder(StringBuilder order) {
            order.append(data).append(",");
            if (left != null) {
                left.preOrder(order);
            }
            if (right != null)
                right.preOrder(order);

            return order;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node current, int data) {
        if (current == null) {
            current = new Node(data);
            return current;
        } else if (data <= current.data) {
            current.left = insert(current.left, data);
        } else {
            current.right = insert(current.right, data);
        }
        return current;
    }

    public String inOrder() {
        String inOrder = "";
        if (root != null) {
            String treeInOrder = root.inOrder(new StringBuilder()).toString();
            inOrder = treeInOrder.substring(0, treeInOrder.length() - 1);
        }
        return inOrder;
    }

    public String preOrder() {
        String preOrder = "";
        if (root != null) {
            String treePreOrder = root.preOrder(new StringBuilder()).toString();
            preOrder = treePreOrder.substring(0, treePreOrder.length() - 1);
        }
        return preOrder;
    }
}
