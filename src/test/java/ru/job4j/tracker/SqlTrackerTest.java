package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    @Test
    public void shouldAddItemInDB() {
        SqlTracker sqlTracker = new SqlTracker();
        Item item = new Item("FromTest");
        Item result = sqlTracker.add(item);
        assertThat(result, is(item));
    }

    @Test
    public void shouldUpdateItemInDB() {
        SqlTracker sqlTracker = new SqlTracker();
        Item item = new Item("Renamed item1");
        boolean result = sqlTracker.replace(1, item);
        assertThat(result, is(true));
    }

    @Test
    public void shouldDeleteItemInDB() {
        SqlTracker sqlTracker = new SqlTracker();
        List<Item> items = sqlTracker.findAll();
        int lastIndex = items.size();
        int id = 1;
        for (Item item : items) {
            if (id < item.getId()) {
                id = item.getId();
            }
        }
        boolean result = sqlTracker.delete(id);
        assertThat(result, is(true));
    }

    @Test
    public void shouldGetAllItemFromDB() {
        SqlTracker sqlTracker = new SqlTracker();
        List<Item> allItem = sqlTracker.findAll();
        assertThat(allItem.isEmpty(), is(false));
    }

    @Test
    public void shouldGetItemByKeyFromDB() {
        SqlTracker sqlTracker = new SqlTracker();
        List<Item> itemsByKey = sqlTracker.findByKey("FromTest");
        assertThat(itemsByKey.isEmpty(), is(false));
    }

    @Test
    public void shouldGetItemByIDFromDB() {
        SqlTracker sqlTracker = new SqlTracker();
        Item itemByID = sqlTracker.findById(1);
        assertThat(itemByID.getId(), is(1));
    }

}