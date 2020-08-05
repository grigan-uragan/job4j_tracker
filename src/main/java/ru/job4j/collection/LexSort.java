package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        String[] first = o1.split("\\.");
        String[] second = o2.split("\\.");
        int index  = Math.min(first.length, second.length);
        for (int i = 0; i < index; i++) {
           int one = Integer.parseInt(first[i]);
           int two = Integer.parseInt(second[i]);
           if (one != two) {
               return Integer.compare(one, two);
           }
        }
        return 0;
    }
}
