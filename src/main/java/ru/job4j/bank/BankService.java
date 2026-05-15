package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);

        if (user == null) {
            return;
        }

        List<Account> accounts = getAccounts(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }

        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);

        if (user == null) {
            return null;
        }

        for (Account account : getAccounts(user)) {
            if (requisite.equals(account.getRequisite())) {
                return account;
            }
        }

        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;

        Account senderAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account payeeAccount = findByRequisite(destinationPassport, destinationRequisite);

        if (senderAccount == null || payeeAccount == null) {
            return false;
        }

        if (senderAccount.getBalance() >= amount) {
            senderAccount.setBalance(senderAccount.getBalance() - amount);
            payeeAccount.setBalance(payeeAccount.getBalance() + amount);
            result = true;
        }

        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}