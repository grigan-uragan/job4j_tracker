package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
       boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select your choice: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    public void showMenu (UserAction[] actions) {
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ShowAllAction(),
                new EditAction(), new DeleteAction(), new FindByIdAction(),
                new FindByNameAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
    }
}
