package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item first = new Item(1, "first");
        Item second = new Item(2, "second");
        Item third = new Item(3, "third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        System.out.println(tracker.findById(3));
    }
}
