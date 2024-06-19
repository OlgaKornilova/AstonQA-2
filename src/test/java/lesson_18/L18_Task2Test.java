package lesson_18;

import lesson_16.DriverManager;
import lesson_16.PaymentChecker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Step;
import io.qameta.allure.Description;

import java.util.List;

public class L18_Task2Test {
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
    @Description("Completing the test Payment information")
    public void fillPaymentInfo() {
        SoftAssert softAssertion = new SoftAssert();
        String phoneNumber = "297777777";
        String sum = "100";
        List<String> expectedPlaceholders = List.of("Номер карты", "Срок действия", "CVV");

        enterPhoneNumber(phoneNumber);
        enterSumNumber(sum);
        clickContinueButton();

        String actualSum = getDisplayedSum();
        String actualSumButton = getDisplayedButtonSum();
        String actualPhoneNumber = getDisplayedPhoneNumber();

        softAssertion.assertTrue(arePaymentSystemIconsPresent(), "Иконки платёжных систем отсутствуют."); // Проверка наличия иконок платёжных систем внутри iframe
        softAssertion.assertEquals(actualSum, sum, "Сумма отображается некорректно. Актуальное значение: " + actualSum); // Проверка корректности отображения суммы
        softAssertion.assertEquals(actualSumButton, sum, "Сумма на кнопке отображается некорректно. Актуальное значение: " + actualSum); // Проверка корректности отображения суммы на кнопке
        softAssertion.assertEquals(actualPhoneNumber, phoneNumber, "Номер телефона отображается некорректно. Актуальное значение: " + actualPhoneNumber); // Проверка корректности отображения номера телефона
        softAssertion.assertTrue(areCardFieldsPlaceholdersCorrect(expectedPlaceholders), "Плейсхолдеры полей для ввода реквизитов карты некорректны."); // Проверка надписей в незаполненных полях для ввода реквизитов карты

        softAssertion.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("Entering phone number: {phoneNumber}")
    public void enterPhoneNumber(String phoneNumber) {
        paymentChecker.enterPhoneNumber(phoneNumber);
    }

    @Step("Entering sum: {sum}")
    public void enterSumNumber(String sum) {
        paymentChecker.enterSumNumber(sum);
    }

    @Step("Clicking the continue button")
    public void clickContinueButton() {
        paymentChecker.clickContinueButton();
    }

    @Step("Getting displayed sum")
    public String getDisplayedSum() {
        return paymentChecker.getDisplayedSum();
    }

    @Step("Getting displayed button sum")
    public String getDisplayedButtonSum() {
        return paymentChecker.getDisplayedButtonSum();
    }

    @Step("Getting displayed phone number")
    public String getDisplayedPhoneNumber() {
        return paymentChecker.getDisplayedPhoneNumber();
    }

    @Step("Checking if payment system icons are present")
    public boolean arePaymentSystemIconsPresent() {
        return paymentChecker.arePaymentSystemIconsPresent();
    }

    @Step("Checking if card fields placeholders are correct")
    public boolean areCardFieldsPlaceholdersCorrect(List<String> expectedPlaceholders) {
        return paymentChecker.areCardFieldsPlaceholdersCorrect(expectedPlaceholders);
    }
}
