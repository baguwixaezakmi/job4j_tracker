package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {

        Book[] books = {
            new Book("Clean code", 464),
            new Book("Effective Java", 416),
            new Book("Head First Java", 720),
            new Book("Java Concurrency in Practice", 384)
        };

        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPages() + " pages");
        }

        System.out.println();

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPages() + " pages");
        }

        System.out.println();

        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPages() + " pages");
            }
        }
    }
}
