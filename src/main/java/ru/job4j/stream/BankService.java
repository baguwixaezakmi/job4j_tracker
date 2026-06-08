package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BankService {
    private final Map<User, List<Account>> users;

    public BankService(Map<User, List<Account>> users) {
        this.users = users;
    }

    public User findByPassport(String passport) {
        return users.keySet()
            .stream()
            .filter(user -> Objects.equals(user.passport(), passport))
            .findFirst()
            .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);

        if (user == null) {
            return null;
        }

        return users.get(user)
            .stream()
            .filter(acc -> Objects.equals(acc.requisite(), requisite))
            .findFirst()
            .orElse(null);
    }
}