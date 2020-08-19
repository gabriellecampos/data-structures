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

    public void insert(int data){
        root = insert(root, data);
    }

    private Node insert(Node current, int data) {
        if (current == null) {
            current = new Node(data);
            return current;
        } else if (data <= current.data) {
            current.left = insert(current.left, data);
        } else {
            root.right = new Node(data);
        }
        return current;
    }
}
