package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    private final Output output;

    public FindByIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Store store) {
        int id  = input.askInt("Please enter Id:");
        Item item = store.findById(id);
        if (item != null) {
            output.println(item);
        } else {
            output.println("Sorry, item by id = " + id + " not found");
        }
        return true;
    }
}
