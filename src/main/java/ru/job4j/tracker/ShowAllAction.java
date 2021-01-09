package ru.job4j.tracker;

import java.util.List;

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
    public boolean execute(Input input, MemTracker memTracker) {
        List<Item> list = memTracker.findAll();
        if (list.isEmpty()) {
            output.println("Is Empty");
        } else {
            for (Item item : list) {
                output.println(item);
            }
        }
        return true;
    }
}
