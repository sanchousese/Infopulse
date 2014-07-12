package Lectures.lecture12072014;

// Created on 7/12/2014.

public class Main extends AllMethods {
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

        sortFilesBySize("C:\\Users\\Sania_000\\Downloads\\Outlast Whistleblower v1.0.12046.0.0u8 +1DLC Repack by REJ01CE");
    }

}
