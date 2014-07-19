package Lectures.lecture19072014;

public interface ListInterface<T> {

    void put(T value);

    void addTo(int index, T value);

    T getCurrent();

    void delete(int index);

    void delete();

    void modify(T value);

    T next();

    T prev();
}
