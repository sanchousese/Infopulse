package Lectures.lecture12072014;

import java.util.Comparator;

/**
 * Created by Sania_000 on 7/12/2014.
 */
public class AnyCharComparator implements Comparator<String> {

    private char aChar;

    public AnyCharComparator(char aChar) {
        this.aChar = aChar;
    }

    private int howManyEntriesOfChar(String string) {
        int result = 0;
        for (Character c : string.toLowerCase().toCharArray())
            if (c.equals(aChar))
                result++;
        return result;
    }

    @Override
    public int compare(String o1, String o2) {
        return howManyEntriesOfChar(o1) - howManyEntriesOfChar(o2);
    }
}
