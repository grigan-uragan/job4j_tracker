package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public User findByPassport(String passport) {
        User result  = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                result = user;
                break;
            }
        }
        return result;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (users.get(user).indexOf(account) == -1) {
                users.get(user).add(account);
            }
        }
    }

    public Account findByRequisite(String passport, String requisite) {
        User user  = findByPassport(passport);
        if (user == null) {
            return null;
        }
        Account result = null;
        List<Account> accounts = users.get(user);
        for (Account account : accounts) {
            if (requisite.equals(account.getRequisite())) {
                result = account;
                break;
            }
        }
        return result;
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
