package Lectures.lecture19072014;

public class DoubleLinkedList<T> implements ListInterface<T> {

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


    protected Node<T> curr;
    private Node<T> head;

    @Override
    public void put(T value) {
        if (curr == null) {
            curr = new Node<T>(value, null, null);
            head = curr;
            return;
        }

        Node<T> tmp = new Node<T>(value, curr, curr.next);
        if (curr.next != null)
            curr.next.prev = tmp;

        if (head.next == null)
            head.next = curr;

        curr.next = tmp;
        curr = curr.next;
    }

    public void addTo(int index, T value) {
        curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        put(value);
    }

    public T getCurrent() {
        return curr.data;
    }

    @Override
    public void delete() {
        if (curr == null)
            return;
        if (curr.next == null && curr.prev == null) {
            curr = null;
            return;
        }
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

    public String toString() {
        String str = "";
        Node<T> tmp = curr;

        while (tmp != null && tmp.next != null)
            tmp = tmp.next;

        while (tmp != null) {
            str += tmp;
            tmp = tmp.prev;
        }
        return str;
    }

    @Override
    public void modify(T value) {
        curr.data = value;
    }
}
