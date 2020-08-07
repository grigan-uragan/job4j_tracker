package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String org1, String org2) {
        String[] o1 = org1.split("/");
        String[] o2 = org2.split("/");
        int result = 0;
        int len = Math.min(o1.length, o2.length);
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                result = o1[i].compareTo(o2[i]);
            } else {
                result = o2[i].compareTo(o1[i]);
            }
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(o1.length, o2.length);
        }
        return result;
    }
}
