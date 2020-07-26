package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id  = input.askInt("Please enter Id:");
        String name = input.askString("Please enter new name:");
        Item item = new Item(id, name);
        boolean isDone = tracker.replace(id, item);
        System.out.println(isDone ? "edit is done" : "invalid command");
        return true;
    }
}
