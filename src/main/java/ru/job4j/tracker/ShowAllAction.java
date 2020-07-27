package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    private final Output output;

    public ShowAllAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "All items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length != 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Is Empty");
        }
        return true;
    }
}
