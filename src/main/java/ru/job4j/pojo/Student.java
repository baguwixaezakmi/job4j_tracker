package ru.job4j.pojo;

import java.time.LocalDate;

public class Student {
    private String initials;
    private int group;
    private LocalDate dateOfReceipt;

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public LocalDate getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(int year, int month, int dayOfMonth) {
        this.dateOfReceipt = LocalDate.of(year, month, dayOfMonth);
    }
}
