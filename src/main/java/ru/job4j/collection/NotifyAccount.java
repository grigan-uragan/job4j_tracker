package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotifyAccount {
    public static Set<Account> sent(List<Account> accounts) {
        Set<Account> result = new HashSet<>();
        for (Account account : accounts) {
            result.add(account);
        }
        return result;
    }
}
