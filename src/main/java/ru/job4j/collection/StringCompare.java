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
            if (first[i] != second[i]) {
                result = first[i] > second[i] ? 1 : -1;
                break;
            }
        }
        if (result == 0 && o1.length() != o2.length()) {
            result = o1.length() > o2.length() ? 1 : -1;
        }
        return result;
    }
}
