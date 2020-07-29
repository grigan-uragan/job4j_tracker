package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public enum TrackerSingleOne {
    INSTANCE;
    private Tracker tracker = new Tracker();

    TrackerSingleOne() {
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }
}
