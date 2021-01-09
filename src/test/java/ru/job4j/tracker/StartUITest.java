package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0", "New Item", "1"}
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {new CreateAction(output), new ExitAction()};
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Create new item" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Create a new Item ====" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Create new item" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                ));
    }

    @Test
    public void whenEditAction() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0", "1", "Renamed Item", "1"}
        );
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New Item"));
        UserAction[] actions = {new EditAction(output), new ExitAction()};
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                + "0. Edit item" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "edit is done" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Edit item" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenDeleteAction() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0", "1", "1"}
        );
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New Item"));
        UserAction[] actions = {new DeleteAction(output), new ExitAction()};
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Delete" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "item already delete" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Delete" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(output).init(in, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{
                "0", "New", "1"
        });
        Item item = new Item("New");
        MemTracker memTracker = new MemTracker();
        memTracker.add(item);
        UserAction[] actions = {new FindByNameAction(output), new ExitAction()};
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Item{id=1, name='New'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{
                "0", "1", "1"
        });
        Item item = new Item("New Item");
        MemTracker memTracker = new MemTracker();
        memTracker.add(item);
        UserAction[] actions = {new FindByIdAction(output), new ExitAction()};
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Item{id=1, name='New Item'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAllAction() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{
                "0", "1"
        });
        Item itemOne = new Item("First Item");
        Item itemTwo = new Item("Second Item");
        MemTracker memTracker = new MemTracker();
        memTracker.add(itemOne);
        memTracker.add(itemTwo);
        UserAction[] actions = {new ShowAllAction(output), new ExitAction()};
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                       + "0. All items" + System.lineSeparator()
                       + "1. Exit" + System.lineSeparator()
                       + "Item{id=1, name='First Item'}" + System.lineSeparator()
                       + "Item{id=2, name='Second Item'}" + System.lineSeparator()
                       + "Menu." + System.lineSeparator()
                       + "0. All items" + System.lineSeparator()
                       + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"5", "0"}
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
                        + "Wrong input, you can select: 0 .. 0" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidShowAllAction() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{
                "4", "0", "1"
        });
        Item itemOne = new Item("First Item");
        Item itemTwo = new Item("Second Item");
        MemTracker memTracker = new MemTracker();
        memTracker.add(itemOne);
        memTracker.add(itemTwo);
        UserAction[] actions = {new ShowAllAction(output), new ExitAction()};
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. All items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Wrong input, you can select: 0 .. 1" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. All items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Item{id=1, name='First Item'}" + System.lineSeparator()
                        + "Item{id=2, name='Second Item'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. All items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidFindByIdAction() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{
                "10", "0", "1", "1"
        });
        Item item = new Item("New Item");
        MemTracker memTracker = new MemTracker();
        memTracker.add(item);
        UserAction[] actions = {new FindByIdAction(output), new ExitAction()};
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find item by Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Wrong input, you can select: 0 .. 1" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Item{id=1, name='New Item'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find item by Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidFindByNameAction() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{
                "4", "0", "New", "1"
        });
        Item item = new Item("New");
        MemTracker memTracker = new MemTracker();
        memTracker.add(item);
        UserAction[] actions = {new FindByNameAction(output), new ExitAction()};
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Wrong input, you can select: 0 .. 1" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Item{id=1, name='New'}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidDeleteAction() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"6", "0", "1", "1"}
        );
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New Item"));
        UserAction[] actions = {new DeleteAction(output), new ExitAction()};
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Delete" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Wrong input, you can select: 0 .. 1" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Delete" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "item already delete" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Delete" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidEditAction() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"7", "0", "1", "Renamed Item", "1"}
        );
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("New Item"));
        UserAction[] actions = {new EditAction(output), new ExitAction()};
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Edit item" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Wrong input, you can select: 0 .. 1" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Edit item" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "edit is done" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Edit item" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidCreateItem() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"5", "0", "New Item", "1"}
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {new CreateAction(output), new ExitAction()};
        new StartUI(output).init(input, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Create new item" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "Wrong input, you can select: 0 .. 1" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Create new item" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Create a new Item ====" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Create new item" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }
}
