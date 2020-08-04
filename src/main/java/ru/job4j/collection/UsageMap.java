package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> users = new HashMap<>();
        users.put("prischepny@yandex.ru", "Prischepny Grigory Victorovich");
        for (String key : users.keySet()) {
            System.out.println(users.get(key));
        }
    }
}
