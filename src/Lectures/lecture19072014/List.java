package Lectures.lecture19072014;

public class List<E> {
    private SLNode<E> head;
    private SLNode<E> tail;
    int size;

    public void push_back(E element) {
        size++;
        if (isEmpty()) {
            head = new SLNode<E>(element);
            tail = head;
            return;
        }

        SLNode<E> temp = head;
        while (temp != tail)
            temp = temp.getNext();
        temp.setNext(new SLNode<E>(element));
        tail = temp.getNext();
    }

    public void push_front(E element) {
        head = new SLNode<E>(element, head);
        size++;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public E pop_front() {
        if (isEmpty())
            return null;

        E temp = head.getElement();
        head = head.getNext();
        size--;
        return temp;
    }

    public E pop_back() {
        if (isEmpty())
            return null;

        if (head == tail) {
            head = null;
            tail = null;
            return null;
        }

        SLNode<E> temp = head;
        while (temp.getNext().getNext() != null)
            temp = temp.getNext();

        E oldLast = temp.getElement();
        temp.setNext(null);
        tail = temp;
        size--;
        return oldLast;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Empty!";

        String result = "";
        SLNode<E> temp = head;
        while (temp.getNext() != null) {
            result += temp.getElement() + ", ";
            temp = temp.getNext();
        }
        return result + temp.getElement();
    }
}
