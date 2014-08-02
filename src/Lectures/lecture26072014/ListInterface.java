package Lectures.lecture26072014;

public interface ListInterface<T> {

    void push_back(T value);

    void push_front(T value);

    void addTo(int index, T value);

    T getCurrent();

    void delete(int index);

    void delete();

    void modify(T value);

    T next();

    T prev();
}
