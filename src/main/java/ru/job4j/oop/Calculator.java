package ru.job4j.oop;

public class Calculator {

    private static final int X = 5;

    public static int sum(int y) {
        return X + y;
    }

    public static int minus(int m) {
        return m - X;
    }

    public int multiply(int a) {
        return X * a;
    }

    public int divide(int d) {
        return d / X;
    }

    public int sumAllOperation(int s) {
        return sum(s) + minus(s) + multiply(s) + divide(s);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(5);
        System.out.println(result);
        System.out.println(minus(5));
        Calculator div = new Calculator();
        System.out.println(div.divide(5));
        Calculator sum = new Calculator();
        System.out.println(sum.sumAllOperation(5));
    }
}