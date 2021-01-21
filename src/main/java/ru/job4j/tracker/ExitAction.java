package ru.job4j.tracker;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store store) {
        try {
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
