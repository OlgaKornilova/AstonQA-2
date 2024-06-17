package lesson_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PaymentChecker {
    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentChecker(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    private By phoneNumberField = By.id("connection-phone");
    private By phoneSumField = By.id("connection-sum");
    private By continueButton = By.xpath("//form[@id='pay-connection']//button[@type='submit']");
    private By paymentIframe = By.cssSelector("iframe.bepaid-iframe");

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void enterSumNumber(String sum) {
        driver.findElement(phoneSumField).clear();
        driver.findElement(phoneSumField).sendKeys(sum);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
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

    public boolean isPaymentIframePresentAndSwitch() {
        try {
            WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentIframe));
            driver.switchTo().frame(iframe);
            return true;
        } catch (Exception e) {
            System.out.println("Iframe not present");
            return false;
        }
    }

    public String getDisplayedSum() {
        WebElement displayedSum = driver.findElement(By.cssSelector(".pay-description__cost"));
        return displayedSum.getText();
    }

    public String getDisplayedButtonSum() {
        WebElement displayedButtonSum = driver.findElement(By.xpath("//div[@class='card-page__card']//button[@type='submit']"));
        return displayedButtonSum.getText();
    }

    public String getDisplayedPhoneNumber() {
        WebElement displayedPhoneNumber = driver.findElement(By.cssSelector(".pay-description__text"));
        String fullText = displayedPhoneNumber.getText();

        // Используем регулярное выражение для извлечения номера телефона
        Pattern pattern = Pattern.compile("Номер:\\s*(\\d+)");
        Matcher matcher = pattern.matcher(fullText);

        if (matcher.find()) {
            return matcher.group(1); // Возвращаем только номер телефона
        } else {
            return "";
        }
    }

    public boolean areCardFieldsPlaceholdersCorrect(List<String> expectedPlaceholders) {
        List<WebElement> cardFields = driver.findElements(By.cssSelector(".card-input input[type='text']"));
        for (int i = 0; i < cardFields.size(); i++) {
            String placeholder = cardFields.get(i).getAttribute("placeholder");
            if (!placeholder.equals(expectedPlaceholders.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean arePaymentSystemIconsPresent() {
        try {
            List<WebElement> icons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'cards-brands__container')]//img")));
            if (!icons.isEmpty()) {
                System.out.println("Found " + icons.size() + "  icons");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Icons not found");
        }
        return false;
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
