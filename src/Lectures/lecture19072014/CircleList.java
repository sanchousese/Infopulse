package Lectures.lecture19072014;


public class CircleList<E> {
    private SLNode<E> current;
    private int size;

    public CircleList() {
        current = new SLNode<E>(null);
        current.setNext(current);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E e) {
        SLNode<E> newOne = new SLNode<E>(e);
        if (isEmpty()) {
            current.setNext(newOne);
            current.setElement(e);
            newOne.setNext(current);
        } else {
            SLNode<E> oldFirst = current.getNext();
            newOne.setNext(oldFirst);
            current.setNext(newOne);
        }
        size++;
    }

    public E pop() {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException();
        SLNode<E> oldFirst = current.getNext();
        current.setNext(oldFirst.getNext());
        oldFirst.setNext(null);
        size--;
        return oldFirst.getElement();
    }

    public E getElement(int index) {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException("Set is Empty");
        if (index < 0)
            index = size + index;
        SLNode<E> temp = current.getNext();
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
            if (current == temp)
                temp = temp.getNext();
        }
        return temp.getElement();
    }

    @Override
    public String toString() {
        String result = "";
        SLNode<E> c = current.getNext();
        while (c != current) {
            result += c.getElement() + ", ";
            c = c.getNext();
        }
        return result;
    }
}
