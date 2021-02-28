package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EditActionTest {

    @Test
    public void whenExecuteCorrectThenEditIsDone() {
        Output out = new StubOutput();
        Input input = mock(Input.class);
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("item"));
        String newName = "new Item";
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askString(any(String.class))).thenReturn(newName);
        EditAction edit = new EditAction(out);
        edit.execute(input, tracker);
        assertThat(out.toString(), is("edit is done\n"));
    }

    @Test
    public void whenExecuteWrongThenInvalidCommand() {
        Output output = new StubOutput();
        Input input = mock(Input.class);
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("item"));
        String newName = "new Item";
        when(input.askInt(any(String.class))).thenReturn(2);
        when(input.askString(any(String.class))).thenReturn(newName);
        EditAction edit = new EditAction(output);
        edit.execute(input, tracker);
        assertThat(output.toString(), is("invalid command\n"));
    }
}