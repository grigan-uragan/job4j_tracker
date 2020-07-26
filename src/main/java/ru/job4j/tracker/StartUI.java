package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {
    private void showMenu() {
        System.out.println("====== MENU ITEMS ======");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
        System.out.println();
    }

    public void init(Input input, Tracker tracker) {
        while (true) {
            this.showMenu();
            int answer = input.askInt("Please selected your choice");
            if (answer == 0) {
                System.out.println("===== Create new item ========");
                String name = input.askString("Please enter name: ");
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (answer == 1) {
                System.out.println("===== All items =====");
                Item[] items = tracker.findAll();
                if (items != null) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Is Empty");
                }
            } else if (answer == 2) {
                System.out.println("==== Edit item ====");
                int id  = input.askInt("Please enter Id:");
                String name = input.askString("Please enter new name:");
                Item item = new Item(id, name);
                boolean isDone = tracker.replace(id, item);
                System.out.println(isDone ? "edit is done" : "invalid command");
            } else if (answer == 3) {
                System.out.println("====== Delete =====");
                int id = input.askInt("Please enter id item for delete:");
                boolean isDone = tracker.delete(id);
                System.out.println(isDone ? "item already delete" : "invalid command");
            } else if (answer == 4) {
                System.out.println("==== Find item by Id =====");
                int id  = input.askInt("Please enter Id:");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Sorry, item by id = " + id + " not found");
                }
            } else if (answer == 5) {
                System.out.println("==== Find items by name ====");
                String name = input.askString("Please enter name:");
                Item[] items = tracker.findByName(name);
                if (items != null) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Items not found!");
                }
            } else if (answer == 6) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
