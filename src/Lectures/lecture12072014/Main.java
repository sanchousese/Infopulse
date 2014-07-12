package Lectures.lecture12072014;


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
        while (!queue.isEmpty()) {
            queue.dequeue();
        }

        System.out.println(queue);

        findFilesWithExe("C:\\ADT\\eclipse");

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
