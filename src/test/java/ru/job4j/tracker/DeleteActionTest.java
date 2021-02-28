package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {
    @Test
    public void whenExecuteCorrectThenItemAlreadyDelete() {
        Output output = new StubOutput();
        Input input = mock(Input.class);
        MemTracker memTracker = new MemTracker();
        memTracker.add(new Item("item"));
        when(input.askInt(any(String.class))).thenReturn(1);
        DeleteAction delete = new DeleteAction(output);
        delete.execute(input, memTracker);
        assertThat(output.toString(), is("item already delete" + System.lineSeparator()));
    }

    @Test
    public void whenExecuteWrongThenInvalidCommand() {
        Output output = new StubOutput();
        Input input = mock(Input.class);
        MemTracker memTracker = new MemTracker();
        memTracker.add(new Item("item"));
        when(input.askInt(any(String.class))).thenReturn(2);
        DeleteAction delete = new DeleteAction(output);
        delete.execute(input, memTracker);
        assertThat(output.toString(), is("invalid command" + System.lineSeparator()));
    }

}