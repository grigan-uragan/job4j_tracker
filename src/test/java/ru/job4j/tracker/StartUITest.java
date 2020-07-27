package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input input = new StubInput(
                new String[]{"0", "New Item", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("New Item"));
    }

    @Test
    public void whenEditAction() {
        Input input = new StubInput(
                new String[]{"0", "1", "Renamed Item", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        UserAction[] actions = {new EditAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Renamed Item"));
    }

    @Test
    public void whenDeleteAction() {
        Input input = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        UserAction[] actions = { new DeleteAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()), nullValue());
    }
}
