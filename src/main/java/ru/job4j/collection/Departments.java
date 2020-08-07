package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> dep) {
        Set<String> temp = new LinkedHashSet<>();
        for (String depart : dep) {
            String start = "";
            for (String el : depart.split("/")) {
                if (start.length() > 1) {
                    start = start + "/" + el;
                } else {
                    start = el;
                }
                temp.add(start);
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
