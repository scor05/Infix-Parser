package infixparser;


public class ListStack<T> implements IStack<T> {
    private final IList<T> list;
    
    public ListStack(IList<T> list) {
        this.list = list;
    }

    // Método agregado para el JUnit
    public IList<T> getList() {
        return list;
    }

    @Override
    public void push(T item) { list.add(item); }
    @Override
    public T pop() { return list.remove(); }
    @Override
    public T peek() { return null; } 
}
