package lesson_12_testng;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Main.factorial(0), 1, "Факториал 0 должен быть равен 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(Main.factorial(5), 120, "Факториал 5 должен быть равен 120");
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(Main.factorial(1), 1, "Факториал 1 должен быть равен 1");
    }

    @Test
    public void testFactorialOfLargeNumber() {
        assertEquals(Main.factorial(10), 3628800, "Факториал 10 должен быть равен 3628800");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Число должно быть неотрицательным")
    public void testFactorialOfNegativeNumber() {
        Main.factorial(-1);
    }
}
