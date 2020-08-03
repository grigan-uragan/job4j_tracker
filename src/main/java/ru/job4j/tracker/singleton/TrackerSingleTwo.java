package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.List;

public class TrackerSingleTwo {
    private static TrackerSingleTwo instance;
    private Tracker tracker = new Tracker();

    private TrackerSingleTwo() {
    }

    public static TrackerSingleTwo getInstance() {
        if (instance == null) {
            instance = new TrackerSingleTwo();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }
}
