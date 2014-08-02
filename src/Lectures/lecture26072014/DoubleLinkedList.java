package Lectures.lecture26072014;

public class DoubleLinkedList<T> implements ListInterface<T> {

    protected Node<T> curr;
    protected Node<T> head;

    private int size;

    @Override
    public void push_back(T value) {
        if (curr == null) {
            curr = new Node<T>(value, null, null);
            head = curr;
            size++;
            return;
        }

        Node<T> tmp = new Node<T>(value, curr, curr.next);
        if (curr.next != null)
            curr.next.prev = tmp;

        if (head.next == null)
            head.next = curr;

        size++;
        curr.next = tmp;
        curr = curr.next;
    }

    @Override
    public void push_front(T value) {
        size++;
        Node<T> temp = new Node<T>(value, null, head);
        head.prev = temp;
        head = temp;
    }

    public void addTo(int index, T value) {
        curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        push_back(value);
    }

    public T getCurrent() {
        if (curr == null)
            return null;
        return curr.data;
    }

    @Override
    public void delete() {
        if (curr == null)
            return;
        if (curr.next == null && curr.prev == null) {
            curr = null;
            head = null;
            size--;
            return;
        }
        size--;
        if (curr.prev != null) {
            curr.prev.next = curr.next;
            if (curr.next != null)
                curr.next.prev = curr.prev;
            curr.next = null;
            curr = curr.prev;
        } else {
            curr = curr.next;
            curr.prev = null;
        }
    }

    public void delete(int index) {
        curr = head;
        for (int i = 0; i < index; i++)
            if (curr.next != null)
                curr = curr.next;
            else {
                System.out.println("Error!");
                curr = head;
                return;
            }

        delete();
    }

    @Override
    public T next() {
        if (curr.next != null) {
            curr = curr.next;
            return curr.data;
        }
        return null;
    }

    @Override
    public T prev() {
        if (curr.prev != null) {
            curr = curr.prev;
            return curr.data;
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        String str = "";
        Node<T> tmp = head;

        while (tmp != null) {
            str += tmp;
            tmp = tmp.next;
        }

        return str;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void modify(T value) {
        curr.data = value;
    }

    @SuppressWarnings("hiding")
    class Node<T> {
        protected T data;
        protected Node<T> next;
        protected Node<T> prev;

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public String toString() {
            return data.toString() + " ";
        }
    }
}
