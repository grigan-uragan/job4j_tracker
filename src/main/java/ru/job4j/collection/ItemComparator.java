package ru.job4j.collection;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
