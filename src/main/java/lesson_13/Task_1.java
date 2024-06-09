package lesson_13;

import java.util.HashMap;
import java.util.Map;

public class Task_1 {
    public static void runTask() {
        // Создаем массив с набором слов, в котором встречаются повторяющиеся
        String[] words = {
                "dog", "cat", "dog", "parrot", "cat", "dog", "lion", "parrot",
                "lion", "tiger", "dog", "cat", "lion", "Tiger", "tiger", "elephant",
                "elephant", "tiger", "elephant", "elephant"
        };

        // Использование HashMap для подсчета вхождений каждого слова
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        // Выводим список уникальных слов, из которых состоит массив с подсчетом повторений
        System.out.println("Список уникальных слов и количество их повторений:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}

