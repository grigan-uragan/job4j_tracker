package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Please enter id item for delete:");
        boolean isDone = tracker.delete(id);
        System.out.println(isDone ? "item already delete" : "invalid command");
        return true;
    }
}
