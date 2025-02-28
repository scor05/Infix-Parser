package infixparser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FactoryTests {
    @Test
    public void shouldReturnArrayListStack() {
        IStack<Integer> stack = StackFactory.getStack("arraylist");
        assertTrue(stack instanceof ArrayListStack);
    }

    @Test
    public void shouldReturnVectorStack() {
        IStack<Integer> stack = StackFactory.getStack("vector");
        assertTrue(stack instanceof VectorStack);
    }

    @Test
    public void shouldReturnSingleLinkedListStack() {
        ListStack<Integer> listStack = (ListStack<Integer>) StackFactory.getListStack("single");
        assertTrue(listStack.getList() instanceof SingleLinkedList);
    }

    @Test
    public void shouldReturnDoubleLinkedListStack() {
        ListStack<Integer> listStack = (ListStack<Integer>) StackFactory.getListStack("double");
        assertTrue(listStack.getList() instanceof DoubleLinkedList);
    }
}
