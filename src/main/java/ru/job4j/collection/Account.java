package ru.job4j.collection;

import java.util.Objects;

public class Account {
    private String password;
    private String username;
    private String deposit;

    public Account(String password, String username, String deposit) {
        this.password = password;
        this.username = username;
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return password.equals(account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    @Override
    public String toString() {
        return "Account{"
               + "password='" + password + '\''
               + ", username='" + username + '\''
               + ", deposit='" + deposit + '\''
               + '}';
    }
}
