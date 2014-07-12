package Lectures.lecture12072014;

import Lectures.lecture05072014.Stack;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Sania_000 on 7/12/2014.
 */
public class AllMethods {
    protected static void sortFilesBySize(String path) {
        File[] files = new File(path).listFiles();
        Arrays.sort(files, new FileComparatorBySize());
        for (int i = 0; i < files.length; i++) System.out.println(files[i].length());
    }

    protected static void sortFilesByLength(String pathname) {
        String[] files = new File(pathname).list();
        Arrays.sort(files, new StringComparator());
        System.out.println(Arrays.toString(files));
    }

    protected static void countingOutGame(int size, int k) {
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

    protected static <T> void reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<T>();
        while (!queue.isEmpty()) stack.push(queue.dequeue());
        while (!stack.isEmpty()) queue.enqueue(stack.pop());
    }

    protected static void findFilesWithExe(String pathname) {
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
