package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void whenExecuteCorrectThenReturnItems() {
        Output output = new StubOutput();
        Input input = mock(Input.class);
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "item");
        tracker.add(item);
        when(input.askString(any(String.class))).thenReturn("item");
        FindByNameAction action = new FindByNameAction(output);
        action.execute(input, tracker);
        assertThat(output.toString(), is(item.toString() + System.lineSeparator()));
    }

    @Test
    public void whenExecuteWrongThenReturnItemsNotFound() {
        Output output = new StubOutput();
        Input input = mock(Input.class);
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "item");
        tracker.add(item);
        when(input.askString(any(String.class))).thenReturn("items");
        FindByNameAction action = new FindByNameAction(output);
        action.execute(input, tracker);
        assertThat(output.toString(), is("Items not found!\n"));
    }
}