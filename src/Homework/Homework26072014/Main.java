package Homework.Homework26072014;

import Lectures.lecture12072014.Queue;

/**
 * Created by Sania_000 on 8/1/2014.
 */
public class Main {

    public static void sort(Queue<Integer> queue) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < queue.size(); i++) {
                if (getByIndex(queue, i) > getByIndex(queue, i + 1)) {
                    swap(queue, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    public static int getByIndex(Queue<Integer> queue, int index) {
        int element;
        for (int i = 0; i < index - 1; i++) {
            int temp = queue.dequeue();
            queue.enqueue(temp);
        }

        element = queue.dequeue();
        queue.enqueue(element);

        for (int i = index; i < queue.size(); i++) {
            int temp = queue.dequeue();
            queue.enqueue(temp);
        }
        return element;
    }

    public static void setByIndex(Queue<Integer> queue, int index, int value) {
        for (int i = 0; i < index - 1; i++) {
            int temp = queue.dequeue();
            queue.enqueue(temp);
        }

        queue.dequeue();
        queue.enqueue(value);

        for (int i = index; i < queue.size(); i++) {
            int temp = queue.dequeue();
            queue.enqueue(temp);
        }
    }

    public static void swap(Queue<Integer> queue, int firstIndex, int secondIndex) {
        int first = getByIndex(queue, firstIndex);
        int second = getByIndex(queue, secondIndex);
        setByIndex(queue, firstIndex, second);
        setByIndex(queue, secondIndex, first);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(13);
        queue.enqueue(1);
        queue.enqueue(23);
        queue.enqueue(5);
        sort(queue);
        System.out.println(queue);
    }


}
