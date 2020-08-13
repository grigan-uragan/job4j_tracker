package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public User findByPassport(String passport) {
        Optional<User> result = users.keySet().stream()
                                    .filter(user -> user.getPassport().equals(passport))
                                    .findFirst();
        return result.orElse(null);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    public Account findByRequisite(String passport, String requisite) {
        User user  = findByPassport(passport);
        if (user == null) {
            return null;
        }
        Optional<Account> result = users.get(user)
                .stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst();
        return result.orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        Account source = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (source == null || dest == null || source.getBalance() < amount) {
            return false;
        }
        source.setBalance(source.getBalance() - amount);
        dest.setBalance(dest.getBalance() + amount);
        return true;
    }
}
