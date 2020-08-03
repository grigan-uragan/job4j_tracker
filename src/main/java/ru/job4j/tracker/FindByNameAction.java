package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {

    private final Output output;

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askString("Please enter name:");
        List<Item> items = tracker.findByName(name);
        if (items.isEmpty()) {
            output.println("Items not found!");
        } else {
            for (Item item : items) {
                output.println(item);
            }
        }
        return true;
    }
}
