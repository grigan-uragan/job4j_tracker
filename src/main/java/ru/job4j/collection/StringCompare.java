package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        int index = Math.min(o1.length(), o2.length());
        char[] first = o1.toCharArray();
        char[] second = o2.toCharArray();
        for (int i = 0; i < index; i++) {
            result = Character.compare(first[i], second[i]);
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(o1.length(), o2.length());
        }
        return result;
    }
}
