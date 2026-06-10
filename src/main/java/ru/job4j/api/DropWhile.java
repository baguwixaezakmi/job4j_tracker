package ru.job4j.api;

import java.util.stream.Stream;

public class DropWhile {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 1, 2)
            .dropWhile(value -> value < 3)
            .map(value -> "Результат: " + value)
            .forEach(System.out::println);
    }
}