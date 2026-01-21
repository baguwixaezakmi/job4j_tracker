package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if (result == - 1) {
            throw new ElementNotFoundException("The element does not exist");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] value = {"1", "2", "3"};
        String key = "5";
        try {
            int index = indexOf(value, key);
            System.out.println(index);
        }  catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
