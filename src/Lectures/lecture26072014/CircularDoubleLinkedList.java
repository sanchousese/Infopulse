package Lectures.lecture26072014;


public class CircularDoubleLinkedList<T> extends DoubleLinkedList<T> {

    @Override
    public void push_back(T value) {
        if (curr == null) {
            curr = new Node<T>(value, null, null);
            curr.next = curr;
            curr.prev = curr;
            head = curr;
            return;
        }

        Node<T> tmp = new Node<T>(value, curr, curr.next);
        boolean b = false;
        if (head == curr)
            b = true;

        curr.next.prev = tmp;
        curr.next = tmp;
        if (b)
            head.next = curr.next;
        curr = curr.next;
    }

    @Override
    public void push_front(T value) {
        super.push_front(value);
    }

    @Override
    public void delete() {
        if (curr == null)
            return;

        if (curr == curr.next) {
            curr = null;
            head = null;
            return;
        }

        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
        curr = curr.prev;
    }

    public void delete(int index) {
        if (index == 0) {
            delete();
            return;
        }
        curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        delete();
    }

    @Override
    public void modify(T value) {
        curr.data = value;
    }

    @Override
    public T next() {
        curr = curr.next;
        return curr.data;
    }

    @Override
    public T prev() {
        curr = curr.prev;
        return curr.data;
    }

    public String toString() {
        String str = new String();

        if (head == null)
            return "empty";

        Node<T> temp = head;
        do {
            str += temp;
            temp = temp.next;
        } while (temp != head);
        return str;
    }
}
