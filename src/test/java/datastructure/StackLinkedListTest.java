package datastructure;

import exception.EmptyStructureException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackLinkedListTest {

    @Test(expected = EmptyStructureException.class)
    public void shouldThrowEmptyStructureExceptionWhenPoppingEmptyStack() throws EmptyStructureException {
        StackLinkedList<String> stack = new StackLinkedList<>();
        stack.pop();
    }

    @Test
    public void shouldReturnOnlyElementInStack() throws EmptyStructureException {
        StackLinkedList<String> stack = new StackLinkedList<>();
        stack.push("element");
        String popped = stack.pop();

        assertEquals(popped, "element");
        assertTrue(stack.isEmpty());
    }

    @Test(expected = EmptyStructureException.class)
    public void shouldThrowEmptyStructureExceptionWhenPoppingMoreThanPushing() throws EmptyStructureException {
        StackLinkedList<String> stack = new StackLinkedList<>();
        stack.push("element1");
        stack.push("element2");
        stack.pop();
        stack.pop();
        stack.pop();
    }

    @Test
    public void shouldPopLastInsertedElementsFirst() throws EmptyStructureException {
        StackLinkedList<String> stack = new StackLinkedList<>();
        stack.push("element1");
        stack.push("element2");
        stack.push("element3");
        String firstPop = stack.pop();
        String secondPop = stack.pop();
        String thirdPop = stack.pop();

        assertEquals(firstPop, "element3");
        assertEquals(secondPop, "element2");
        assertEquals(thirdPop, "element1");
        assertTrue(stack.isEmpty());
    }
}