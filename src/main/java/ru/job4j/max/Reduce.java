package ru.job4j.max;

public class Reduce {
    private int[] numbers;

    public void to(int[] numbers) {
        this.numbers = numbers;
    }

    public void print() {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(numbers);
        reduce.print();
    }
}