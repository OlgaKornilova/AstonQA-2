package lesson_12_junit_5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, Main.factorial(0), "Факториал 0 должен быть равен 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(120, Main.factorial(5), "Факториал 5 должен быть равен 120");
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, Main.factorial(1), "Факториал 1 должен быть равен 1");
    }

    @Test
    public void testFactorialOfLargeNumber() {
        assertEquals(3628800, Main.factorial(10), "Факториал 10 должен быть равен 3628800");
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.factorial(-1);
        });

        String expectedMessage = "Число должно быть неотрицательным";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Сообщение исключения должно содержать: " + expectedMessage);
    }
}