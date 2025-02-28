import java.util.Vector;

public class VectorStack<T> implements IStack<T> {
    private final Vector<T> stack = new Vector<>();

    @Override
    public void push(T item) { stack.add(item); }
    @Override
    public T pop() { return stack.isEmpty() ? null : stack.remove(stack.size() - 1); }
    @Override
    public T peek() { return stack.isEmpty() ? null : stack.get(stack.size() - 1); }
    /**
     * 
     * @return
     */
    public Vector<T> getStack() {
        return stack;
    }
}
