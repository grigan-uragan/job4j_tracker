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
        System.out.println("Please selected your choice");
    }

    public void init(Scanner scanner, Tracker tracker) {
        while (true) {
            this.showMenu();
            int answer = Integer.parseInt(scanner.nextLine());
            if (answer == 0) {
                System.out.println("===== Create new item ========");
                System.out.println("Please enter name: ");
                String name = scanner.nextLine();
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
                System.out.println("Please enter Id:");
                int id  = Integer.parseInt(scanner.nextLine());
                System.out.println("Please enter new name:");
                String name = scanner.nextLine();
                Item item = new Item(id, name);
                boolean isDone = tracker.replace(id, item);
                System.out.println(isDone ? "edit is done" : "invalid command");
            } else if (answer == 3) {
                System.out.println("====== Delete =====");
                System.out.println("Please enter id item for delete:");
                int id = Integer.parseInt(scanner.nextLine());
                boolean isDone = tracker.delete(id);
                System.out.println(isDone ? "item already delete" : "invalid command");
            } else if (answer == 4) {
                System.out.println("==== Find item by Id =====");
                System.out.println("Please enter Id:");
                int id  = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Sorry, item by id = " + id + " not found");
                }
            } else if (answer == 5) {
                System.out.println("==== Find items by name ====");
                System.out.println("Please enter name:");
                String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
