package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;

import java.util.List;

public enum TrackerSingleOne {
    INSTANCE;
    private MemTracker memTracker = new MemTracker();

    TrackerSingleOne() {
    }

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public boolean delete(int id) {
        return memTracker.delete(id);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public List<Item> findByName(String name) {
        return memTracker.findByKey(name);
    }

    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }
}
