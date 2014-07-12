package Lectures.lecture12072014;


import Lectures.lecture05072014.Stack;

import java.io.File;

/**
 * Created by Sania on 7/12/2014.
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(13);
        queue.enqueue(34);
        queue.enqueue(143);

        System.out.println(queue);

        reverse(queue);
        System.out.println(queue);

        while (!queue.isEmpty()) queue.dequeue();

        System.out.println(queue);

        findFilesWithExe("C:\\ADT\\eclipse");

        countingOutGame(10, 3);
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
        System.out.println("Виграв:\t" + queue.dequeue());
    }

    private static void reverse(Queue queue) {
        Stack stack = new Stack();
        while (!queue.isEmpty()) stack.push(queue.dequeue());
        while (!stack.isEmpty()) queue.enqueue(stack.pop());
    }

    private static void findFilesWithExe(String pathname) {
        Queue<String> stringQueue = new Queue<String>();
        String[] file = new File(pathname).list();

        for (int i = 0; i < file.length; i++) {
            stringQueue.enqueue(file[i]);
        }

        System.out.println(stringQueue);

        while (!stringQueue.isEmpty()) {
            String dequeue = stringQueue.dequeue();
            if (dequeue.contains(".exe"))
                System.out.println(dequeue);
        }
    }
}
