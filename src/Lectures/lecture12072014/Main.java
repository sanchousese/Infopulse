package Lectures.lecture12072014;


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
    }
}
