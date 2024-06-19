package lesson_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PlaceholderChecker {
    private WebDriver driver;
    private WebDriverWait wait;
    private String formSelector;

    public PlaceholderChecker(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }

    public void closeCookieBanner() {
        try {
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cookie")));
            cookieBanner.findElement(By.id("cookie-agree")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cookie")));
        } catch (Exception e) {
            System.out.println("Cookie banner not found or already closed.");
        }
    }

    public void selectService(String serviceName) {
        WebElement dropdown = driver.findElement(By.cssSelector(".select__header"));
        dropdown.click(); // Открываем выпадающее меню

        WebElement optionToSelect = driver.findElement(By.xpath("//p[text()='" + serviceName + "']"));
        optionToSelect.click(); // Кликаем на нужную опцию

        // Ждем пока форма не откроется
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay-form.opened")));
    }


    public List<WebElement> getInputFields() {
        WebElement activeForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay-form.opened")));
        return activeForm.findElements(By.cssSelector("input[type='text']"));
    }

}
