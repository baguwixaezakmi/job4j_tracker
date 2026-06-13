package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (key, value) -> map.put(key, value);
        List<String> values = List.of("one", "two", "three", "four", "five", "six", "seven");

        int i = 1;
        for (String number : values) {
            biConsumer.accept(i++, number);
        }

        BiPredicate<Integer, String> biPredicate = (key, value) -> key % 2 == 0 || value.length() == 4;
        for (Integer key : map.keySet()) {
            if (biPredicate.test(key, map.get(key))) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }

        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        List<String> strings = supplier.get();

        Consumer<String> consumer = (string) -> System.out.println(string);
        Function<String, String> function = (string) -> string.toUpperCase();
        for (String string : strings) {
            consumer.accept(function.apply(string));
        }
    }
}