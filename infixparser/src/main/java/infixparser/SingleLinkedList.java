package infixparser;

import infixparser.IList;
public class SingleLinkedList<T> implements IList<T> {
    private class Node {
        T data;
        Node next;
        Node(T data) { this.data = data; }
    }

    private Node head;

    @Override
    public void add(T item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public T remove() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        return data;
    }
}
