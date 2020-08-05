package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            List<Account> accounts = new ArrayList<>();
            users.put(user, accounts);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport));
            return user;
        }
        return null;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
          List<Account> list =  users.get(user);
          if (!list.contains(account)) {
              users.get(user).add(account);
          }
        }
    }
}
