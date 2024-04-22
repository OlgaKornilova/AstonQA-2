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

        int[] IntArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        changeArray(IntArray);

        int[] EmptyArray = new int[100];
        fullArray(EmptyArray);

        int[] MultArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeNum(MultArray);

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
        int sum = a + b; // Суммируем a и b

        if (sum >= 0) {
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
        int sum = a + b; // Сумма двух чисел
        return sum >= 10 && sum <= 20; // Проверяем, лежит ли сумма в заданном диапазоне
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
        if (year % 400 == 0) {
            return true; // Если год делится без остатка на 400 - високосный
        } else if (year % 100 == 0) {
            return false; // Если год делится без остатка на 100 - НЕвисокосный
        } else {
            return year % 4 == 0; // При этом, если делится на 4 без остатка - високосный
        }
    }
    // Задание 10

    public static void changeArray(int[] IntArray) {
        for (int i = 0; i < IntArray.length; i++) {
            IntArray[i] = IntArray[i] == 0 ? 1 : 0;
        }

        System.out.println("Модифицированный массив: ");
        for (int j : IntArray) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    // Задание 11
    public static void fullArray(int[] EmptyArray) {
        for (int i = 0; i < EmptyArray.length; i++) {
            EmptyArray[i] = i + 1;
        }

        System.out.println("Заполненный массив:");
        for (int value : EmptyArray) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Задание 12
    public static void changeNum(int[] MultArray) {
        for (int i = 0; i < MultArray.length; i++) {
            if (MultArray[i] < 6) {
                MultArray[i] *= 2;
            }
        }

        System.out.println("Массив, в котором числа меньше 6 умножены на 2:");
        for (int value : MultArray) {
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


