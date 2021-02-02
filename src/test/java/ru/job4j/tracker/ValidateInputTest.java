package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInputThenOutput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(out.toString(), is(
                "Please enter validate data again." + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidInputSevenTimes() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{
                "one", "one", "one", "one", "one", "one", "one", "1"});
        ValidateInput validate = new ValidateInput(input, output);
        validate.askInt("Enter menu:");
        assertThat("Please enter validate data again." + System.lineSeparator()
                + "Please enter validate data again." + System.lineSeparator()
                + "Please enter validate data again." + System.lineSeparator()
                + "Please enter validate data again." + System.lineSeparator()
                + "Please enter validate data again." + System.lineSeparator()
                + "Please enter validate data again." + System.lineSeparator()
                + "Please enter validate data again." + System.lineSeparator(),
                is(output.toString()));
    }

    @Test
    public void whenNegativeDigitInput() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"-1", "1"});
        ValidateInput validate = new ValidateInput(input, output);
        int result = validate.askInt("Enter menu:");
        assertThat(-1, is(result));
    }

}