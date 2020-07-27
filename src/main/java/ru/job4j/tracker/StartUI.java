package ru.job4j.tracker;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
       boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select your choice: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    public void showMenu(UserAction[] actions) {
        output.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            output.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output), new ShowAllAction(output),
                new EditAction(output), new DeleteAction(output), new FindByIdAction(output),
                new FindByNameAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
    }
}
