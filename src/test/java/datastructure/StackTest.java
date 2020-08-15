package datastructure;

import exception.EmptyStructureException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    @Test
    public void shouldReturnOnlyElementOfStack() throws EmptyStructureException {
        Stack stack = new Stack(2);
        stack.push(1);
        assertEquals(stack.pop(), 1);
        assertEquals(stack.getTop(), 0);
    }

    @Test(expected = EmptyStructureException.class)
    public void shouldThrowEmptyStructureExceptionWhenPoppingAnEmptyStack() throws EmptyStructureException {
        Stack stack = new Stack(2);
        stack.pop();
    }

    @Test
    public void shouldDoubleStackSizeWhenItReachesCapacity() {
        Stack stack = new Stack(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(stack.getCapacity(), 4);
    }

    @Test(expected = EmptyStructureException.class)
    public void shouldThrowEmptyStructureExceptionWhenPoppingMoreTimesThanPushing() throws EmptyStructureException {
        Stack stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }

    @Test
    public void shouldPopLastInsertedElementInTheStack() throws EmptyStructureException {
        Stack stack = new Stack(3);
        stack.push(4);
        stack.push(7);
        stack.push(1);
        assertEquals(stack.pop(), 1);
        assertEquals(stack.getTop(), 2);
    }
}