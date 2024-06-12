package lesson_15;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getOnlinePaymentBlockTitle(String expectedTitle) {
        // Закрываем баннер cookie, если он присутствует
        try {
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cookie")));
            cookieBanner.findElement(By.id("cookie-agree")).click();
        } catch (Exception e) {
            System.out.println("Cookie banner not found or already closed.");
        }

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='pay']//h2[contains(text(), '" + expectedTitle + "')]")));
            return element.getText();
        } catch (TimeoutException e) {
            WebElement fallbackElement = driver.findElement(By.xpath("//section[@class='pay']//h2"));
            return fallbackElement.getText();
        }
    }

    public boolean arePaymentSystemLogosDisplayed() {
        try {
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__partners']//img")));
            //System.out.println("Логотип найден url: " + logo.getAttribute("src"));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickMoreAboutServiceLink(String expectedUrl) {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Подробнее о сервисе')]")));

        // Открытие ссылки в новом окне
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0].href, '_blank');", link);

        // Переключение на новую вкладку и проверка URL
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        wait.until(ExpectedConditions.urlContains(expectedUrl));

        // Возвращение к исходной вкладке
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }
}
