package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String org1, String org2) {
        String[] o1 = org1.split("/");
        String[] o2 = org2.split("/");
        int result = o2[0].compareTo(o1[0]);
        if (result == 0) {
            result = org1.compareTo(org2);
        }
        return result;
    }
}
