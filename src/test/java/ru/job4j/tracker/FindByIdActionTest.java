package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void whenExecuteCorrectThenReturnItem() {
        Output output = new StubOutput();
        Input input = mock(Input.class);
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "item");
        tracker.add(item);
        when(input.askInt(any(String.class))).thenReturn(1);
        FindByIdAction find = new FindByIdAction(output);
        find.execute(input, tracker);
        assertThat(output.toString(), is(item.toString() + System.lineSeparator()));
    }

    @Test
    public void whenExecuteWrongThenReturnSorryItemNotFound() {
        Output output = new StubOutput();
        Input input = mock(Input.class);
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "item");
        tracker.add(item);
        when(input.askInt(any(String.class))).thenReturn(2);
        FindByIdAction find = new FindByIdAction(output);
        find.execute(input, tracker);
        assertThat(output.toString(), is("Sorry, item by id = 2 not found\n"));
    }
}