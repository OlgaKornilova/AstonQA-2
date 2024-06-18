package lesson_16;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test_2 {
    private WebDriver driver;
    private PaymentChecker paymentChecker;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get("http://mts.by");
        paymentChecker = new PaymentChecker(driver);
        paymentChecker.closeCookieBanner();
    }

    @Test
    public void fillPaymentInfo() {
        SoftAssert softAssertion= new SoftAssert();
        String phoneNumber = "297777777";
        String sum = "100";
        List<String> expectedPlaceholders = List.of("Номер карты", "Срок действия", "CVV");

        paymentChecker.enterPhoneNumber(phoneNumber);
        paymentChecker.enterSumNumber(sum);
        paymentChecker.clickContinueButton();

        String actualSum = paymentChecker.getDisplayedSum();
        String actualSumButton = paymentChecker.getDisplayedButtonSum();
        String actualPhoneNumber = paymentChecker.getDisplayedPhoneNumber();

        softAssertion.assertTrue(paymentChecker.arePaymentSystemIconsPresent(), "Иконки платёжных систем отсутствуют."); // Проверка наличия иконок платёжных систем внутри iframe
        softAssertion.assertEquals(actualSum, sum, "Сумма отображается некорректно. Актуальное значение: " + actualSum); // Проверка корректности отображения суммы
        softAssertion.assertEquals(actualSumButton, sum, "Сумма на кнопке отображается некорректно. Актуальное значение: " + actualSum); // Проверка корректности отображения суммы на кнопке
        softAssertion.assertEquals(actualPhoneNumber, phoneNumber, "Номер телефона отображается некорректно. Актуальное значение: " + actualPhoneNumber); // Проверка корректности отображения номера телефона
        softAssertion.assertTrue(paymentChecker.areCardFieldsPlaceholdersCorrect(expectedPlaceholders), "Плейсхолдеры полей для ввода реквизитов карты некорректны."); // Проверка надписей в незаполненных полях для ввода реквизитов карты

        softAssertion.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
