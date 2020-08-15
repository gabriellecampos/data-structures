package datastructure;

import exception.EmptyStructureException;
import lombok.Getter;

@Getter
public class Stack {
    private int[] stack;
    private int top;
    private int capacity;

    public Stack(int size) {
        stack = new int[size];
        capacity = size;
        top = 0;
    }

    public void push(int number) {
        if(isStackFull()) {
            this.duplicateStackCapacity();
        }
        stack[top] = number;
        top += 1;
    }

    public int pop() throws EmptyStructureException {
        if(isStackEmpty()){
            throw new EmptyStructureException();
        }
        top -= 1;
        return  stack[top];
    }


    private void duplicateStackCapacity() {
        int stackCurrentSize = stack.length;
        int[] tempStack = new int[stackCurrentSize*2];
        for(int i = 0; i < stackCurrentSize; i++){
            tempStack[i] = this.stack[i];
        }
        this.stack = tempStack;
        this.capacity = this.stack.length;
    }

    private void printStack(){
        for(int i = 0; i < top || i == 0; i = i+1){
            System.out.print(stack[i]+", ");
        }
        System.out.println();
    }

    private boolean isStackFull(){
        return top >= stack.length;
    }

    private boolean isStackEmpty() {
        return top <= 0;
    }

}
