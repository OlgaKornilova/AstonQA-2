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

        // Проверка наличия и переключения на iframe
        assertTrue(paymentChecker.isPaymentIframePresentAndSwitch(), "Кнопка 'Продолжить' не работает. Платежный виджет не отображен.");

        // Проверка наличия иконок платёжных систем внутри iframe
        assertTrue(paymentChecker.arePaymentSystemIconsPresent(), "Иконки платёжных систем отсутствуют.");

        // Проверка корректности отображения суммы
        String actualSum = paymentChecker.getDisplayedSum();
        softAssertion.assertEquals(actualSum, sum, "Сумма отображается некорректно. Актуальное значение: " + actualSum);

        // Проверка корректности отображения суммы на кнопке
        String actualSumButton = paymentChecker.getDisplayedButtonSum();
        softAssertion.assertEquals(actualSumButton, sum, "Сумма на кнопке отображается некорректно. Актуальное значение: " + actualSum);

        // Проверка корректности отображения номера телефона
        String actualPhoneNumber = paymentChecker.getDisplayedPhoneNumber();
        softAssertion.assertEquals(actualPhoneNumber, phoneNumber, "Номер телефона отображается некорректно. Актуальное значение: " + actualPhoneNumber);



        // Проверка надписей в незаполненных полях для ввода реквизитов карты
        assertTrue(paymentChecker.areCardFieldsPlaceholdersCorrect(expectedPlaceholders), "Плейсхолдеры полей для ввода реквизитов карты некорректны.");

        paymentChecker.switchToDefaultContent();

        softAssertion.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
