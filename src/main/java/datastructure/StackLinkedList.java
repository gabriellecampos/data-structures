package datastructure;

import exception.EmptyStructureException;
import lombok.Getter;

@Getter
public class StackLinkedList<T> {

    private class StackNode<T>{
        private T data;
        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() throws EmptyStructureException {
        if(this.top == null){
            throw new EmptyStructureException();
        }
        T data = this.top.data;
        this.top = this.top.next;

        return data;
    }

    public void push(T data) {
        StackNode<T> newNode = new StackNode<>(data);
        newNode.next = this.top;
        this.top = newNode;

    }

    public boolean isEmpty(){
        return this.top == null;
    }

    public void printStack(){
        if(top == null){
            System.out.println("Empty stack");
        }else{
            StackNode next = this.top;
            while(next != null){
                System.out.print(next.data+", ");
                next = next.next;
            }
            System.out.println();
        }
    }
}
