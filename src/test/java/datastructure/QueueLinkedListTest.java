package datastructure;

import exception.EmptyStructureException;
import org.junit.Test;

import static org.junit.Assert.*;


public class QueueLinkedListTest {

    @Test
    public void shouldHaveFirstAndLastEqualWhenThereIsOnlyOneElement() {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.add(1);

        assertSame(queue.getFirst(), queue.getLast());
    }

    @Test
    public void shouldLeaveFirstAndLastNodesAsNullWhenRemovingOnlyNodeInQueue() throws EmptyStructureException {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.add(1);
        queue.remove();
        assertNull(queue.getFirst());
        assertNull(queue.getLast());
    }

    @Test
    public void shouldHaveDifferentFirstAndLastNodeWhenThereIsMoreThanOneElement() {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.add(1);
        queue.add(1);
        assertNotSame(queue.getFirst(), queue.getLast());
    }

    @Test(expected = EmptyStructureException.class)
    public void shouldThrowEmptyStructureExceptionWhenTryingToRemoveFromEmptyQueue() throws EmptyStructureException {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.remove();
    }

    @Test(expected = EmptyStructureException.class)
    public void shouldThrowEmptyStructureExceptionWhenTryingToRemoveMoreThanInsertingIntoQueue() throws EmptyStructureException {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.remove();
        queue.remove();
        queue.remove();
    }
}