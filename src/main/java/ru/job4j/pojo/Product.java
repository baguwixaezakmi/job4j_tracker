package ru.job4j.pojo;

import java.time.LocalDateTime;

public class Product {
    private String name;
    private int count;
    private LocalDateTime created;

    public Product(String name, int count) {
        this(name, count, LocalDateTime.now());
    }

    public Product(String name, int count, LocalDateTime created) {
        this.name = name;
        this.count = count;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
