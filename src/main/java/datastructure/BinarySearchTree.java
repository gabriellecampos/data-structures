package datastructure;

import exception.MyNodeNotFoundException;
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

        public StringBuilder postOrder(StringBuilder order) {
            if (left != null) {
                left.postOrder(order);
            }
            if (right != null) {
                right.postOrder(order);
            }
            order.append(data).append(",");
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

    public String postOrder() {
        String postOrder = "";
        if (root != null) {
            String treePostOrder = root.postOrder(new StringBuilder()).toString();
            postOrder = treePostOrder.substring(0, treePostOrder.length() - 1);
        }
        return postOrder;
    }

    public Node find(int number) throws MyNodeNotFoundException {
        return find(root, number);
    }

    private Node find(Node current, int data) throws MyNodeNotFoundException {
        if (current == null) {
            throw new MyNodeNotFoundException();
        } else if (current.data == data) {
            return current;
        } else if (data < current.data) {
            return find(current.left, data);
        } else {
            return find(current.right, data);
        }
    }

    public void remove(int number) throws MyNodeNotFoundException {
        root = remove(root, number);
    }

    private Node remove(Node current, int data) throws MyNodeNotFoundException {
        if(current == null){
            throw new MyNodeNotFoundException();
        }else if(data < current.data){
            current.left = remove(current.left, data);
            return current;
        }else if(data > current.data){
            current.right = remove(current.right, data);
            return current;
        }else{
            if(current.left == null && current.right == null){
                return null;
            }else if (current.left == null){
                return current.right;
            }else if(current.right == null){
                return current.left;
            }else{
                int minValue = minValue(current.right);
                current.data = minValue;
                current.right = remove(current.right, minValue);
            }
        }
        return current;
    }

    private int minValue(Node current){
        if(current.left != null){
            return minValue(current.left);
        }
        return current.data;
    }

}
