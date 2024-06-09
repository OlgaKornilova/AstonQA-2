package lesson_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task_2 {
    private final Map<String, List<String>> phoneBook = new HashMap<>();

    // Метод, который добавляет записи в телефонный справочник
    public void add(String surname, String phoneNumber) {
        // Проверка существует ли уже такая фамилия в справочнике
        phoneBook.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Метод, который получает все телефонные номера по фамилии
    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }

    public static void runTask() {
        Task_2 phoneBook = new Task_2();
        phoneBook.add("Ivanov", "123-456-789");
        phoneBook.add("Ivanov", "234-567-890");
        phoneBook.add("Petrov", "345-678-901");
        phoneBook.add("Sidorov", "456-789-012");

        System.out.println("Numbers for Ivanov: " + phoneBook.get("Ivanov"));
        System.out.println("Numbers for Petrov: " + phoneBook.get("Petrov"));
        System.out.println("Numbers for Sidorov: " + phoneBook.get("Sidorov"));
    }
}
