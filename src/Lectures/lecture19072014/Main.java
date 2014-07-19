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

        for (String l : ls) System.out.println(l.length() - l.replace("a", "").length() == 2);
        for (String l : ls) System.out.println(l.toLowerCase().matches("([^a]*a[^a]*){2}"));

    }
}
