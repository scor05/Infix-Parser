package infixparser;

import infixparser.IList;
import infixparser.IStack;

public class ListStack<T> implements IStack<T> {
    private final IList<T> list;
    
    public ListStack(IList<T> list) {
        this.list = list;
    }

    @Override
    public void push(T item) { list.add(item); }
    @Override
    public T pop() { return list.remove(); }
    @Override
    public T peek() { return null; } 
}
