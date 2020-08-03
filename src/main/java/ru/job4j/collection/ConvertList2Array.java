package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int group = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[group][cells];
        int row = 0;
        int cell = 0;
        for (Integer num : list) {
            if (cell >= cells) {
                cell = 0;
                row++;
            }
            array[row][cell++] = num;
        }
        return array;
    }
}
