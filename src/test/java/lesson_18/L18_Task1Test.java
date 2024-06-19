package lesson_18;

import lesson_16.DriverManager;
import lesson_16.PlaceholderChecker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class L18_Task1Test {
    private WebDriver driver;
    private PlaceholderChecker placeholderChecker;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get("http://mts.by");
        placeholderChecker = new PlaceholderChecker(driver);
        placeholderChecker.closeCookieBanner();
    }

    @Test
    public void testPlaceholders() {
        checkPlaceholders("Услуги связи", List.of("Номер телефона", "Сумма", "E-mail для отправки чека"));
        checkPlaceholders("Домашний интернет", List.of("Номер абонента", "Сумма", "E-mail для отправки чека"));
        checkPlaceholders("Рассрочка", List.of("Номер счета на 44", "Сумма", "E-mail для отправки чека"));
        checkPlaceholders("Задолженность", List.of("Номер счета на 2073", "Сумма", "E-mail для отправки чека"));
    }

    private void checkPlaceholders(String serviceName, List<String> expectedPlaceholders) {
        placeholderChecker.selectService(serviceName);
        List<WebElement> inputFields = placeholderChecker.getInputFields();

        for (int i = 0; i < inputFields.size(); i++) {
            String placeholder = inputFields.get(i).getAttribute("placeholder");
            Assert.assertEquals(placeholder, expectedPlaceholders.get(i), "Placeholder не совпадает для поля " + (i + 1) + " в разделе " + serviceName);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
