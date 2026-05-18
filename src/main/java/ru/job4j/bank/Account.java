package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель банковского счёта клиента.
 *
 * @see BankService
 * @see User
 */
public class Account {
    /**
     * Уникальные банковские реквизиты счёта.
     * Используются как идентификатор в {@link #equals(Object)}.
     */
    private String requisite;
    /**
     * Баланс на банковском счёте.
     * Не участвует в сравнении объектов, см. {@link #equals(Object)}.
     */
    private double balance;

    /**
     * Создаёт счёт с указанными реквизитами и балансом.
     *
     * @param requisite уникальные реквизиты счёта
     * @param balance   начальный баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает реквизиты счёта.
     *
     * @return реквизиты счёта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает реквизиты счёта.
     *
     * @param requisite новые реквизиты счёта
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращает баланс счёта.
     *
     * @return баланс счёта
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает баланс счёта.
     *
     * @param balance новый баланс счёта
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает счета по реквизитам.
     * Баланс при сравнении не учитывается.
     *
     * @param o объект для сравнения
     * @return {@code true}, если реквизиты совпадают, иначе {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Согласован с {@link #equals(Object)}.
     *
     * @return хэш-код, вычисленный по полю {@code requisite}
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}