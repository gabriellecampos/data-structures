package datastructure;

import exception.EmptyStructureException;
import lombok.Getter;

@Getter
public class QueueLinkedList<T> {

    private class QueueNode<T>{
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T data){
        QueueNode<T> newNode = new QueueNode<>(data);

        if(last != null){
            last.next = newNode;
        }
        last = newNode;

        if(first == null){
            first = last;
        }
    }

    public T remove() throws EmptyStructureException {
        if(first == null){
            throw new EmptyStructureException();
        }

        T data = first.data;
        first = first.next;
        if(first == null){
            last = null;
        }
        return data;
    }

    public boolean isEmpty(){
        return first == null && last == null;
    }

    public void printQueue(){
        if(first == null){
            System.out.println("Empty Queue");
        }else{
            QueueNode<T> next = this.first;
            while(next != null){
                System.out.print(next.data+", ");
                next = next.next;
            }
            System.out.println();
        }
    }

}
