package Lectures.lecture12072014;

//Created on 7/12/2014.

import java.io.File;
import java.util.Comparator;

public class FileComparatorBySize implements Comparator<File> {
    @Override
    public int compare(File o1, File o2) {
        if (o1.length() - o2.length() > 0)
            return 1;
        else if (o1.length() - o2.length() < 0)
            return -1;
        else return 0;
    }
}
