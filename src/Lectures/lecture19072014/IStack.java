package Lectures.lecture19072014;

public interface IStack<T> {
    T pop();

    void push(T s);

    T peek();

    int size();

    boolean isEmpty();
}
