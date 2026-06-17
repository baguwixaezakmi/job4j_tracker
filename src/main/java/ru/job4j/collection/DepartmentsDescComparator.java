package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        Objects.requireNonNull(left);
        Objects.requireNonNull(right);
        String[] l = left.split("/");
        String[] r = right.split("/");
        int rsl = r[0].compareTo(l[0]);
        if (rsl == 0) {
            rsl = left.compareTo(right);
        }
        return rsl;
    }
}