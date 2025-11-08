package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setInitials("Иван Иванов");
        student.setGroup(1);
        student.setDateOfReceipt(2025, 11, 8);
        System.out.println(
            student.getInitials() + " поступил в группу " + student.getGroup()
                + System.lineSeparator()
                + "Дата: " + student.getDateOfReceipt()
        );
    }
}
