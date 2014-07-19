package Lectures.lecture19072014;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new List<Integer>();
        list.push_back(13);
        list.push_back(14);
        list.push_back(15);
        System.out.println(list);

        while (!list.isEmpty())
            System.out.println(list.pop_back());

        System.out.println(list);

        String ls[] = {"Asm", "Basic", "Pascal", "C++"};

        for (String l : ls) System.out.println(l.length() - l.replace("a", "").length() == 2);
        for (String l : ls) System.out.println(l.toLowerCase().matches("([^a]*a[^a]*){2}"));


        CircleList<Integer> list1 = new CircleList<Integer>();
        for (int i = 0; i < 10; i++)
            list1.push(i);
        System.out.println(list1 + "\t" + list1.getSize());
        System.out.println(list1.getElement(4));

        String[] fs = {"B", "c", "D", "d"};
        mySort(fs);
        System.out.println(Arrays.toString(fs));
    }


    private static void mySort(Comparable[] mas) {
        for (int i = 1; i < mas.length; i++) {
            int currentIndex = i;
            while ((currentIndex > 0) && mas[currentIndex].compareTo(mas[currentIndex - 1]) < 0) {
                swap(mas, currentIndex);
                currentIndex--;
            }
        }
    }

    private static void swap(Object[] mas, int currentIndex) {
        Object temp = mas[currentIndex];
        mas[currentIndex] = mas[currentIndex - 1];
        mas[currentIndex - 1] = temp;
    }

}
