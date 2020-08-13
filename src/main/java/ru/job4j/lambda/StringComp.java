package ru.job4j.lambda;

import java.util.Comparator;

public class StringComp {
    private Comparator<String> comparator = (left, right) -> {
        System.out.println("compare: " + left.length() + " : " + right.length());
        return right.length() - left.length();
    };
}
