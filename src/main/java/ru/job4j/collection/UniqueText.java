package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class UniqueText {
    public static boolean isEquals(String origin, String duplicate) {
        boolean result = true;
        String[] originalText = origin.split(" ");
        String[] duplicateText = duplicate.split(" ");
        Set<String> check = new HashSet<>();
        for (String str : originalText) {
            check.add(str);
        }
        for (String dup : duplicateText) {
            if (!check.contains(dup)) {
                result = false;
            }
        }
        return result;
    }
}
