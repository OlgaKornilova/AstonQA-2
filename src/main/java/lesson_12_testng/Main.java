package lesson_12_testng;

public class Main {
    // Метод для вычисления факториала
    public static long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 5; // Пример числа для вычисления факториала
        long fact = factorial(number);
        System.out.println("Факториал " + number + " равен " + fact);
    }
}
