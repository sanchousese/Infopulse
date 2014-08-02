package Lectures.lecture26072014;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

        for (int i = 0; i < 30; i++)
            list.push_back((int) (Math.random() * 1000));
        System.out.println(list);

        ArrayList<String> arrayList = new ArrayList<String>();
        String[] ps = {"Washington", "Adams", "Monroe", "Bush"};
        Collections.addAll(arrayList, ps);

        System.out.println(arrayList);

        for (String anArrayList : arrayList) {
            System.out.println(anArrayList);
        }

        LinkedList<String> linkedList = new LinkedList<String>();
        Collections.addAll(linkedList, ps);
        for (String aLinkedList : linkedList) System.out.println(aLinkedList);

        SimpleIter simpleIter = new SimpleIter();
        for (Integer aSimpleIter : simpleIter) System.out.println(aSimpleIter);
    }
}
