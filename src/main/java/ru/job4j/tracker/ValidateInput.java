package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int result = -1;
        do {
            try {
                result = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return result;
    }
}
