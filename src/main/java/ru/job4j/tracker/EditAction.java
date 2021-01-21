package ru.job4j.tracker;

public class EditAction implements UserAction {

    private final Output output;

    public EditAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        int id  = input.askInt("Please enter Id:");
        String name = input.askString("Please enter new name:");
        Item item = new Item(id, name);
        boolean isDone = store.replace(id, item);
        output.println(isDone ? "edit is done" : "invalid command");
        return true;
    }
}
