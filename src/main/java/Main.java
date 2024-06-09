public class Main {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(sumInRange(3, 3));// Результат: false
        positiveOrNegativeNumber(0);// Результат: Число положительное
        System.out.println(isNegative(5)); // Результат: false
        printStringMultipleTimes("Hi,Aston!", 5);
        System.out.println(isLeapYear(2000)); //Ожидаемый результат: true

        int[] intArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        changeArray(intArray);

        int[] emptyArray = new int[100];
        fullArray(emptyArray);

        int[] multArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeNum(multArray);

        int size = 6; //Задаем раазмер матрицы
        createDiagonalMatrix(size);

        int len = 8; // Длинна массива
        int initialValue = 3; // Значение элемента для массива
        createArray(len, initialValue);
    }

    // Задание 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Задание 2
    public static void checkSumSign() {
        int a = 10; // Задаем значение переменной a
        int b = -5; // Задаем значение переменной b

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Задание 3
    public static void printColor() {
        int value = 101; // Задаем значение переменной value

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // Задание 4
    public static void compareNumbers() {
        int a = 5; // Задаем значение переменной a
        int b = 10; // Задаем значение переменной b

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // Задание 5
    public static boolean sumInRange(int a, int b) {
        return (a + b >= 10) && (a + b <= 20); // Проверяем, лежит ли сумма в заданном диапазоне
    }

    // Задание 6
    public static void positiveOrNegativeNumber(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // Задание 7
    public static boolean isNegative(int number) {
        return number < 0; // Возвращает true, если число отрицательное
    }

    // Задание 8
    public static void printStringMultipleTimes(String text, int count) {
        // Цикл выполняется < count раз
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    // Задание 9
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
    // Задание 10

    public static void changeArray(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = intArray[i] == 0 ? 1 : 0;
        }

        System.out.println("Модифицированный массив: ");
        for (int j : intArray) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    // Задание 11
    public static void fullArray(int[] emptyArray) {
        for (int i = 0; i < emptyArray.length; i++) {
            emptyArray[i] = i + 1;
        }

        System.out.println("Заполненный массив:");
        for (int value : emptyArray) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


    // Задание 12
    public static void changeNum(int[] multArray) {
        for (int i = 0; i < multArray.length; i++) {
            if (multArray[i] < 6) {
                multArray[i] *= 2;
            }
        }
        System.out.println("Массив, в котором числа меньше 6 умножены на 2:");
        for (int value : multArray) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Задание 13
    public static void createDiagonalMatrix(int size) {
        int[][] matrix = new int[size][size];

        // Заполнение диагонали единицами
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }

        System.out.println("Заполненный многомерный массив: ");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    //Задание 14
    public static void createArray(int len, int initialValue) {
        int[] array = new int[len];

        // Заполняем массив значениями initialValue
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }

        System.out.println("Возвращаем заполненный массив:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}


