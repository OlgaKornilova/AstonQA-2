package lesson_15;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private static WebDriver driver;
    private static HomePage homePage;
    private static OnlinePaymentPage onlinePaymentPage;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverManagerUtil.getDriver();
        driver.get("http://mts.by");
        homePage = new HomePage(driver);
        onlinePaymentPage = new OnlinePaymentPage(driver);
        homePage.closeCookieBanner();
    }

    @Test
    public void testBlockTitle() {
        String expectedTitle = "Онлайн пополнение без комиссии";
        String actualTitle = homePage.getOnlinePaymentBlockTitle(expectedTitle);
        assertTrue(actualTitle.contains("Онлайн") && actualTitle.contains("пополнение") && actualTitle.contains("комиссии"),
                "Название блока не содержит ожидаемые ключевые слова.");
    }

    @Test
    public void testPaymentSystemLogos() {
        assertTrue(homePage.arePaymentSystemLogosDisplayed(), "Логотипы платёжных систем не отображаются.");
    }

    @Test
    public void testMoreAboutServiceLink() {
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        homePage.clickMoreAboutServiceLink(expectedUrl);
        // Переключение на новое окно и проверка URL
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        assertTrue(driver.getCurrentUrl().contains(expectedUrl), "Ссылка 'Подробнее о сервисе' не работает.");
        // Возвращение к исходному окну
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }

    @Test
    public void testContinueButtonFunctionality() {
        onlinePaymentPage.enterPhoneNumber("297777777");
        onlinePaymentPage.enterSumNumber("100");
        onlinePaymentPage.enterEmail("test@test.com");
        onlinePaymentPage.clickContinueButton();

        // Проверка наличия iframe
        assertTrue(onlinePaymentPage.isPaymentIframePresent(), "Кнопка 'Продолжить' не работает. Платежный виджет не отображен.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
