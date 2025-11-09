package ru.job4j.pojo;

public class Book {
    private final String name;
    private final int pages;

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public int getPages() {
        return pages;
    }

}
