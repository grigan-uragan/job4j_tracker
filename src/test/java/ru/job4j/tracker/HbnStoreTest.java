package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class HbnStoreTest {

    @Test
    public void whenAddItemThenFindAllReturnItem() {
        Item result = null;
        Item item = new Item("first item", "for tests");
        try (HbnStore store = new HbnStore("src/test/resources/hibernate.cfg.xml")) {
            store.add(item);
            result = store.findAll().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(result, is(item));
    }

    @Test
    public void whenAddItemThenFindByIdReturnItem() {
        Item result = null;
        Item item = new Item("first item", "for tests");
        try (HbnStore store = new HbnStore("src/test/resources/hibernate.cfg.xml")) {
            store.add(item);
            result = store.findById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(result, is(item));
    }

    @Test
    public void whenAddItemThenFindByKeyReturnItem() {
        Item result = null;
        Item item = new Item("first item", "for tests");
        try (HbnStore store = new HbnStore("src/test/resources/hibernate.cfg.xml")) {
            store.add(item);
            result = store.findByKey("first item").get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(result, is(item));
    }

    @Test
    public void whenAddItemAndAfterReplaceThenFindAllReturnNewItem() {
        Item result = null;
        Item item = new Item("first item", "for tests");
        Item newItem = new Item("second item", "this item was replace");
        try (HbnStore store = new HbnStore("src/test/resources/hibernate.cfg.xml")) {
            store.add(item);
            store.replace(1, newItem);
            result = store.findAll().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(result, is(newItem));
    }

    @Test
    public void whenAddItemAndAfterDeleteThenFindAllReturnEmptyList() {
        Item item = new Item("first item", "for tests");
        List<Item> result = null;
        try (HbnStore store = new HbnStore("src/test/resources/hibernate.cfg.xml")) {
            store.add(item);
            store.delete(1);
            result = store.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(result.isEmpty(), is(true));
    }

}