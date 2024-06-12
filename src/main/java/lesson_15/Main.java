package lesson_15;

import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nЗапуск тестов для блока 'Онлайн пополнение без комиссии' на сайте mts.by");

        WebDriver driver = WebDriverManagerUtil.getDriver();
        driver.get("http://www.mts.by/");

        HomePage homePage = new HomePage(driver);
        OnlinePaymentPage onlinePaymentPage = new OnlinePaymentPage(driver);

        System.out.println("\nПроверка названия блока:");
        testBlockTitle(homePage);

        System.out.println("\nПроверка наличия логотипов платёжных систем:");
        testPaymentSystemLogos(homePage);

        System.out.println("\nПроверка работы ссылки 'Подробнее о сервисе':");
        testMoreAboutServiceLink(homePage, driver);

        System.out.println("\nПроверка работы кнопки 'Продолжить':");
        testContinueButtonFunctionality(onlinePaymentPage, driver);

        driver.quit();
    }

    private static void testBlockTitle(HomePage homePage) {
        String expectedTitle = "Онлайн пополнение без комиссии";
        String actualTitle = homePage.getOnlinePaymentBlockTitle(expectedTitle);
        if (!actualTitle.equals(expectedTitle)) {
            System.out.println("Название блока не совпадает с ожидаемым. Ожидаемое: " + expectedTitle + ", Фактическое: " + actualTitle);
        } else {
            System.out.println("Название блока совпадает с ожидаемым.");
        }
    }

    private static void testPaymentSystemLogos(HomePage homePage) {
        if (!homePage.arePaymentSystemLogosDisplayed()) {
            System.out.println("Логотипы платёжных систем не отображаются.");
        } else {
            System.out.println("Логотипы платёжных систем отображаются.");
        }
    }

    private static void testMoreAboutServiceLink(HomePage homePage, WebDriver driver) {
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        homePage.clickMoreAboutServiceLink(expectedUrl);
        if (!driver.getCurrentUrl().contains(expectedUrl)) {
            System.out.println("Ссылка 'Подробнее о сервисе' работает.");
        } else {
            System.out.println("Ссылка 'Подробнее о сервисе' не работает. ");
        }
    }

    private static void testContinueButtonFunctionality(OnlinePaymentPage onlinePaymentPage, WebDriver driver) {
        onlinePaymentPage.enterPhoneNumber("297777777");
        onlinePaymentPage.enterSumNumber("100");
        onlinePaymentPage.enterEmail("test@test.com");
        onlinePaymentPage.clickContinueButton();

        // Проверка наличия iframe
        boolean isIframePresent = onlinePaymentPage.isPaymentIframePresent();

        if (isIframePresent) {
            System.out.println("Кнопка 'Продолжить' работает. Платежный виджет отображен.");
        } else {
            System.out.println("Кнопка 'Продолжить' не работает. Платежный виджет не отображен.");
        }
    }
}
