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
    public boolean execute(Input input, MemTracker memTracker) {
        output.println("=== Create a new Item ====");
        String name = input.askString("Please enter name: ");
        Item item = new Item(name);
        memTracker.add(item);
        return true;
    }
}
