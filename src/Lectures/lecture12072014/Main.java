package Lectures.lecture12072014;


import Lectures.lecture05072014.Stack;

import java.io.File;
import java.util.Arrays;

// Created on 7/12/2014.

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(13);
        queue.enqueue(34);
        queue.enqueue(143);

        System.out.println(queue);

        reverseQueue(queue);
        System.out.println(queue);

        while (!queue.isEmpty()) queue.dequeue();

        System.out.println(queue);

        findFilesWithExe("C:\\ADT\\eclipse");

        countingOutGame(10, 3);

        sortFilesByLength("C:\\Windows");
    }

    private static void sortFilesByLength(String pathname) {
        String[] files = new File(pathname).list();
        Arrays.sort(files, new StringComparator());
        System.out.println(Arrays.toString(files));
    }

    private static void countingOutGame(int size, int k) {
        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 0; i < size; i++) queue.enqueue(i + 1);
        int counter = 0;
        while (queue.size() > 1) {
            if (counter++ == k - 1) {
                counter = 0;
                System.out.println("Вибув:\t" + queue.dequeue());
            } else
                queue.enqueue(queue.dequeue());
        }
        System.out.println("Виграв:\t" + queue.getFront());
    }

    private static <T> void reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<T>();
        while (!queue.isEmpty()) stack.push(queue.dequeue());
        while (!stack.isEmpty()) queue.enqueue(stack.pop());
    }

    private static void findFilesWithExe(String pathname) {
        Queue<String> stringQueue = new Queue<String>();
        String[] file = new File(pathname).list();

        for (String aFile : file) stringQueue.enqueue(aFile);

        System.out.println(stringQueue);

        while (!stringQueue.isEmpty()) {
            String dequeue = stringQueue.dequeue();
            if (dequeue.contains(".exe"))
                System.out.println(dequeue);
        }
    }
}
