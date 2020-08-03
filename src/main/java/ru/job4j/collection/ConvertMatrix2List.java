package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                result.add(cell);
            }
        }
        return result;
    }
}
