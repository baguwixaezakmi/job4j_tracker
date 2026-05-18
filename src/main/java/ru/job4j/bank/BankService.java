package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Сервис для управления банковскими счетами пользователей.
 * Хранит соответствие между пользователями и их счетами.
 *
 * @see User
 * @see Account
 */
public class BankService {
    /**
     * Хранилище пользователей и их счетов.
     * Каждому пользователю соответствует список его счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя в систему.
     * Если пользователь уже существует, ничего не происходит.
     *
     * @param user добавляемый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из системы по номеру паспорта.
     * Если пользователь не найден, ничего не происходит.
     *
     * @param passport номер паспорта пользователя
     */
    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    /**
     * Добавляет счёт пользователю.
     * Если пользователь не найден или счёт уже существует, ничего не происходит.
     *
     * @param passport номер паспорта пользователя
     * @param account  добавляемый счёт
     */
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

    /**
     * Ищет пользователя по номеру паспорта.
     *
     * @param passport номер паспорта
     * @return пользователь или {@code null}, если не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Ищет счёт пользователя по номеру паспорта и реквизитам.
     *
     * @param passport  номер паспорта пользователя
     * @param requisite реквизиты счёта
     * @return счёт или {@code null}, если пользователь или счёт не найдены
     */
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

    /**
     * Переводит средства с одного счёта на другой.
     * Перевод не выполняется, если отправитель или получатель не найдены,
     * либо на счёте отправителя недостаточно средств.
     *
     * @param sourcePassport       номер паспорта отправителя
     * @param sourceRequisite      реквизиты счёта отправителя
     * @param destinationPassport  номер паспорта получателя
     * @param destinationRequisite реквизиты счёта получателя
     * @param amount               сумма перевода
     * @return {@code true}, если перевод выполнен успешно, иначе {@code false}
     */
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

    /**
     * Возвращает список счетов пользователя.
     *
     * @param user пользователь
     * @return список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}