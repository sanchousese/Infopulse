package Lectures.lecture19072014;

public class SLNode<E> {
    private E element;
    private SLNode<E> next;

    public SLNode(E element) {
        this.element = element;
    }

    public SLNode(E element, SLNode<E> next) {
        this.element = element;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public SLNode<E> getNext() {
        return next;
    }

    public void setNext(SLNode<E> next) {
        this.next = next;
    }
}
