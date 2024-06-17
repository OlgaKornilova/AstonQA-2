package lesson_16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager; // Импортируем нужный класс

public class DriverManager {
    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup(); // Правильная настройка драйвера
        return new ChromeDriver();
    }

    public static void quitDriver() {
        WebDriverManager.chromedriver().quit();
    }
}