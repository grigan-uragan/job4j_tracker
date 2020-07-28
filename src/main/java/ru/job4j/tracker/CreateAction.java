package ru.job4j.tracker;

public class CreateAction implements UserAction {

    private final Output output;

    public CreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Create new item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Create a new Item ====");
        String name = input.askString("Please enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}
