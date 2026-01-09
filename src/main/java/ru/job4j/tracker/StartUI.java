package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выбрать: ");
            int select = input.askInt("Enter menu item: ");
            switch (select) {
                case 0 -> {
                    System.out.println("=== Создание новой заявки ===");
                    System.out.print("Введите имя: ");
                    String name = input.askStr("Enter name: ");
                    Item item = new Item(name);
                    tracker.add(item);
                    System.out.println("Добавленная заявка: " + item);
                }
                case 1 -> {
                    System.out.println("=== Вывод всех заявок ===");
                    Item[] items = tracker.findAll();
                    if (items.length > 0) {
                        for (Item item : items) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("Хранилище еще не содержит заявок");
                    }
                }
                case 2 -> {
                    System.out.println("=== Редактирование заявки ===");
                    System.out.print("Введите id: ");
                    int id = input.askInt("Enter id: ");
                    System.out.print("Введите имя: ");
                    String name = input.askStr("Enter name: ");
                    Item item = new Item(name);

                    if (tracker.replace(id, item)) {
                        System.out.println("Заявка изменена успешно.");
                    } else {
                        System.out.println("Ошибка замены заявки.");
                    }
                }
                case 3 -> {
                    System.out.println("=== Удаление заявки ===");
                    System.out.print("Введите id: ");
                    int id = input.askInt("Enter id: ");
                    Item item = tracker.findById(id);
                    tracker.delete(id);
                    System.out.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
                }
                case 4 -> {
                    System.out.println("=== Вывод заявки по id ===");
                    System.out.print("Введите id: ");
                    int id = input.askInt("Enter id: ");
                    Item item = tracker.findById(id);
                    if (item != null) {
                        System.out.println(item);
                    } else {
                        System.out.println("Заявка с введенным id: " + id + " не найдена.");
                    }
                }
                case 5 -> {
                    System.out.println("=== Вывод заявок по имени ===");
                    System.out.print("Введите имя: ");
                    String name = input.askStr("Enter name: ");
                    Item[] items = tracker.findByName(name);
                    if (items.length > 0) {
                        for (Item item : items) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("Заявки с именем: " + name + " не найдены.");
                    }
                }
                case 6 -> run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку", "Показать все заявки", "Изменить заявку",
                "Удалить заявку", "Показать заявку по id", "Показать заявки по имени",
                "Завершить программу"
        };
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new MockInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}