package infixparser;
import java.util.ArrayList;

public class ArrayListStack<T> implements IStack<T> {
    private final ArrayList<T> stack = new ArrayList<>();
    
    @Override
    public void push(T item) { stack.add(item); }
    @Override
    public T pop() { return stack.isEmpty() ? null : stack.remove(stack.size() - 1); }
    @Override
    public T peek() { return stack.isEmpty() ? null : stack.get(stack.size() - 1); }
}
