package datastructure;

import exception.EmptyStructureException;
import exception.MyNodeNotFoundException;
import lombok.Getter;

@Getter
public class BinarySearchTree {

    @Getter
    public class Node {

        int data;
        boolean visited;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.visited = false;
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

        public void visit(){
            this.visited = true;
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

    public int distance(int a, int b) throws MyNodeNotFoundException {
        int temp;

        if(a > b){
            temp = a;
            a = b;
            b = temp;
        }
        return distance(root, a ,b);
    }

    private int distance(Node current, int a, int b) throws MyNodeNotFoundException {
        if(current == null){
            return 0;
        }
        if(a < current.data && b < current.data){
            return distance(current.left, a ,b);
        }
        if(a > current.data && b> current.data){
            return distance(current.right, a, b);
        }
        return nodeDistance(current, a) + nodeDistance(current, b);
    }

    private int nodeDistance(Node current, int data) throws MyNodeNotFoundException {
        if(current == null){
            throw new MyNodeNotFoundException();
        }
        if(data == current.data){
            return 0;
        }
        if(data < current.data){
            return 1 + nodeDistance(current.left, data);
        }
        return 1 + nodeDistance(current.right, data);
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

    public boolean breadthFirstSearch(int value) throws EmptyStructureException {
        return breadthFirstSearch(root, value);
    }

    private  boolean breadthFirstSearch(Node root, int value) throws EmptyStructureException {
        QueueLinkedList<Node> queue = new QueueLinkedList<>();
        root.visit();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node queuedNode = queue.remove();
            System.out.print(String.format("%d,", queuedNode.data));
            if (queuedNode.data == value) {
                return true;
            } else {
                Node leftAdjacentNode = queuedNode.left;
                Node rightAdjacentNode = queuedNode.right;
                if(isValidNode(leftAdjacentNode)){
                    leftAdjacentNode.visit();
                    queue.add(leftAdjacentNode);
                }
                if(isValidNode(rightAdjacentNode)){
                    rightAdjacentNode.visit();
                    queue.add(rightAdjacentNode);
                }
            }
        }
        return false;
    }

    private boolean isValidNode(Node node){
        return node != null && !node.isVisited();
    }

    private int minValue(Node current){
        if(current.left != null){
            return minValue(current.left);
        }
        return current.data;
    }

}
