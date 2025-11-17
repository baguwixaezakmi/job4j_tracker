package ru.job4j.pojo;

import java.time.LocalDate;

public class License {
    private String owner;
    private String model;
    private String code;
    private LocalDate created;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(int year, int month, int dayOfMonth) {
        this.created = LocalDate.of(year, month, dayOfMonth);
    }
}
