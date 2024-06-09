package lesson_8;

public class Main {
    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] incorrectArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "x", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
                {"17", "18", "19", "20"}
        };

        try {
            System.out.println("Сумма корректного массива: " + Task.processArray(correctArray));
            System.out.println("Сумма некорректного массива: " + Task.processArray(incorrectArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
