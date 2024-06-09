package lesson_8;

public class Task {
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

    static boolean anyRowNotFour(String[][] array) {
        for (String[] row : array) {
            if (row.length != 4) {
                return true;
            }
        }
        return false;
    }
}
