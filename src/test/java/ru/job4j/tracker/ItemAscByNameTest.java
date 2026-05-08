package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    void ascByName() {
        List<Item> list = Arrays.asList(
            new Item("Bob"),
            new Item("Alex"),
            new Item("Conor")
        );
        list.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
            new Item("Alex"),
            new Item("Bob"),
            new Item("Conor")
        );
        assertThat(list).isEqualTo(expected);
    }
}