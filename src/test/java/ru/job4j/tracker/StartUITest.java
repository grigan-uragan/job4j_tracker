package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {item.getId() + "", "replaced"};
        StartUI.editItems(new StubInput(answers), tracker);
        Item item1 = tracker.findById(item.getId());
        assertThat(item1.getName(), is("replaced"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        int id = item.getId();
        String[] answers = {id + ""};
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item item1 = tracker.findById(id);
        assertThat(item1, nullValue());
    }

}