package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель пользователя банковской системы.
 * Идентичность пользователя определяется по номеру паспорта.
 *
 * @see Account
 * @see BankService
 */
public class User {
    /**
     * Номер паспорта пользователя.
     * Используется как идентификатор в {@link #equals(Object)}.
     */
    private String passport;
    /**
     * Имя пользователя.
     * Не участвует в сравнении объектов, см. {@link #equals(Object)}.
     */
    private String username;

    /**
     * Создаёт пользователя с указанным паспортом и именем.
     *
     * @param passport номер паспорта пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает номер паспорта пользователя.
     *
     * @return номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает номер паспорта пользователя.
     *
     * @param passport новый номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает имя пользователя.
     *
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя.
     *
     * @param username новое имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает пользователей по номеру паспорта.
     * Имя пользователя при сравнении не учитывается.
     *
     * @param o объект для сравнения
     * @return {@code true}, если номера паспортов совпадают, иначе {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Согласован с {@link #equals(Object)}.
     *
     * @return хэш-код, вычисленный по полю {@code passport}
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}