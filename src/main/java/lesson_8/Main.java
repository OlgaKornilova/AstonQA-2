package lesson_8;

public class Main {
    // Определение собственного исключения для неверного размера массива
    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    // Определение собственного исключения для ошибок данных в массиве
    static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

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
            System.out.println("Сумма корректного массива: " + processArray(correctArray));
            System.out.println("Сумма некорректного массива: " + processArray(incorrectArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || anyRowNotFour(array)) {
            throw new MyArraySizeException("Массив должен быть размером 4x4.");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке (" + i + "," + j + ")");
                }
            }
        }
        return sum;
    }

    private static boolean anyRowNotFour(String[][] array) {
        for (String[] row : array) {
            if (row.length != 4) {
                return true;
            }
        }
        return false;
    }
}
