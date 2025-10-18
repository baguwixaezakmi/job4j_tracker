package ru.job4j.oop;

public class Error {

    boolean active;
    int status;
    String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(this.active);
        System.out.println(this.status);
        System.out.println(this.message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 40, "bla bla");
        Error error3 = new Error(false, 20, "blu blu");
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
