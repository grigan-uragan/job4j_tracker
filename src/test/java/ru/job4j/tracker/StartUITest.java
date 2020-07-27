package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input input = new StubInput(
                new String[]{"0", "New Item", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("New Item"));
    }

    @Test
    public void whenEditAction() {
        Output output = new ConsoleOutput();
        Input input = new StubInput(
                new String[]{"0", "1", "Renamed Item", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        UserAction[] actions = {new EditAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Renamed Item"));
    }

    @Test
    public void whenDeleteAction() {
        Output output = new ConsoleOutput();
        Input input = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        UserAction[] actions = { new DeleteAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()), nullValue());
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{
                "0", "New", "1"
        });
        Item item = new Item("New");
        Tracker tracker = new Tracker();
        tracker.add(item);
        UserAction[] actions = {new FindByNameAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findByName(item.getName())[0].toString(), is("Item{id=1, name='New'}"));
    }

    @Test
    public void whenFindByIdAction() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{
                "0", "1", "1"
        });
        Item item = new Item("New Item");
        Tracker tracker = new Tracker();
        tracker.add(item);
        UserAction[] actions = {new FindByIdAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).toString(), is("Item{id=1, name='New Item'}"));
    }

    @Test
    public void whenShowAllAction() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{
                "0", "1"
        });
        Item itemOne = new Item("First Item");
        Item itemTwo = new Item("Second Item");
        Tracker tracker = new Tracker();
        tracker.add(itemOne);
        tracker.add(itemTwo);
        UserAction[] actions = {new ShowAllAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[1].getName(), is("Second Item"));
    }
}
