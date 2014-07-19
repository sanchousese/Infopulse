package Lectures.lecture19072014;

public class Stack<T> implements IStack<T> {

    private Node<T> tail;
    private int size;

    public void push(T data) {
        if (isEmpty())
            tail = new Node<T>(data, null);
        else {
            Node<T> temp = new Node<T>(data, tail);
            tail = temp;
        }
        size++;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public T pop() {
        if (isEmpty())
            return null;

        T temp = tail.data;
        tail = tail.prev;
        size--;
        return temp;
    }

    public T peek() {
        if (isEmpty())
            return null;
        return tail.data;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String result = new String();
        Node<T> temp = tail;
        while (temp != null) {
            result += temp + ", ";
            temp = temp.prev;
        }
        return result;
    }

    @SuppressWarnings("hiding")
    private class Node<T> {
        T data;
        Node<T> prev;

        public Node(T data, Node<T> prev) {
            this.data = data;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}