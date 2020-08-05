package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ItemComparatorTest {

    @Test
    public void whenCompareClassic() {
        Item first = new Item(1, "first");
        Item second = new Item(2, "second");
        Item third = new Item(3, "third");
        List<Item> list = new LinkedList<>();
        list.add(third);
        list.add(first);
        list.add(second);
        list.sort(new ItemComparator());
        assertThat(list.toArray(), is(new Item[]{first, second, third}));
    }

    @Test
    public void whenCompareReverse() {
        Item first = new Item(1, "first");
        Item second = new Item(2, "second");
        Item third = new Item(3, "third");
        List<Item> list = new LinkedList<>();
        list.add(third);
        list.add(first);
        list.add(second);
        list.sort(new ItemReverseComparator());
        assertThat(list.toArray(), is(new Item[]{third, second, first}));
    }

}