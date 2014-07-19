package Lectures.lecture19072014;

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

        for (int i = 0; i < ls.length; i++) {
            System.out.println(ls[i].length() - ls[i].replace("a", "").length() == 2);
        }

        for (int i = 0; i < ls.length; i++)
            System.out.println(ls[i].toLowerCase().matches("([^a]*a[^a]*){2}"));
    }
}
