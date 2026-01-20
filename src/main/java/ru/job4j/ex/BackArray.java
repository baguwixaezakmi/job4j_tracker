package ru.job4j.ex;

public class BackArray {
    public String[] turn(String[] names) {
        int middle = names.length / 2;
        for (int index = 0; index < middle; index++) {
            String temp = names[index];
            int lastIndex = names.length - 1;
            names[index] = names[lastIndex - index];
            names[lastIndex - index] = temp;
        }
        return names;
    }
}