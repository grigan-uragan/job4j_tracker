package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input input;
    private final Output output;

    public ValidateInput(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int result = -1;
        do {
            try {
                result = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException ex) {
                output.println("Please enter validate data again.");
            }
        } while (invalid);
        return result;
    }

    @Override
    public String askString(String question) {
        return input.askString(question);
    }
}
