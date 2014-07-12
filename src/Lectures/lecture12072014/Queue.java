package Lectures.lecture12072014;

/**
 * Created by Sania_000 on 7/12/2014.
 */
public class Queue<T> {
    private T[] mas;
    private int start, end;

    public Queue() {
        mas = (T[]) new Object[8];
    }

    public int size() {
        return end - start;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int realIndex(int index) {
        return index % mas.length;
    }

    private int realIndex(int index, int N) {
        return index % N;
    }

    private void resize() {
        T[] temp = (T[]) new Object[mas.length * 2];
        for (int i = 0; i < end; i++) {
            temp[realIndex(i, temp.length)] = mas[realIndex(i)];
        }
        mas = temp;
    }

    public void enqueue(T element) {
        if (size() >= mas.length)
            resize();
        mas[realIndex(end++)] = element;
    }

    public T dequeue() {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException();
        return mas[realIndex(start++)];
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = start; i < end; i++)
            result += mas[realIndex(i)];
        return result;
    }
}
