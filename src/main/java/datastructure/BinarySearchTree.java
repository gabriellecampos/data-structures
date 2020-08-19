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
    }

    private Node root;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            this.root = newNode;
        } else if (data <= root.data) {
            root.left = newNode;
        } else {
            root.right = newNode;
        }
    }
}
