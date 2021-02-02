package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Method add new User in
     * map {@link #users}
     * @param user client of bank
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    /**
     * method try find user use passport data
     * @param passport user data
     * @return Optional user if user contains in users,
     * or empty Optional if lose
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> result = users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
        return result;
    }

    /**
     * method try add account to user account list if
     * user present in {@link #users} and don't have same
     * account in List of accounts
     * @param passport user data
     * @param account user account, where user hold money
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * method find Account by user passport data
     * and account requisite data
     * @param passport user data
     * @param requisite account data
     * @return Optional Account if present or empty Optional if lose
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isEmpty()) {
            return Optional.empty();
        }
        Optional<Account> result = users.get(user.get())
                .stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst();
        return result;
    }

    /**
     * method create transaction from first user to second user
     * used user passport data and account requisite data
     * {@see findByRequisite}
     * @param srcPassport from user data
     * @param srcRequisite account data
     * @param destPassport to user data
     * @param destRequisite to account data
     * @param amount money for transfer
     * @return {@code true} if transaction complete else return {@code false}
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        Account source = findByRequisite(srcPassport, srcRequisite).orElse(null);
        Account dest = findByRequisite(destPassport, destRequisite).orElse(null);
        if (source == null || dest == null || source.getBalance() < amount) {
            return false;
        }
        source.setBalance(source.getBalance() - amount);
        dest.setBalance(dest.getBalance() + amount);
        return true;
    }
}
