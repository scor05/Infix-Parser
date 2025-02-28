package infixparser;
public class DoubleLinkedList<T> implements IList<T> {
    private class Node {
        T data;
        Node prev;
        Node(T data) { this.data = data; }
    }

    private Node tail;

    @Override
    public void add(T item) {
        Node newNode = new Node(item);
        if (tail == null) {
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail = newNode;
        }
    }

    @Override
    public T remove() {
        if (tail == null) return null;
        T data = tail.data;
        tail = tail.prev;
        return data;
    }
}
