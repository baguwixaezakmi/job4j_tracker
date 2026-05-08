package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    void descByName() {
        List<Item> list = Arrays.asList(
            new Item("Bob"),
            new Item("Alex"),
            new Item("Conor")
        );
        list.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
            new Item("Conor"),
            new Item("Bob"),
            new Item("Alex")
        );
        assertThat(list).isEqualTo(expected);
    }
}