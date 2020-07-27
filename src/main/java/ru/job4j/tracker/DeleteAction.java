package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Please enter id item for delete:");
        boolean isDone = tracker.delete(id);
        output.println(isDone ? "item already delete" : "invalid command");
        return true;
    }
}
