package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlinePaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Locators
    private By phoneNumberField = By.id("connection-phone");
    private By phoneSumField = By.id("connection-sum");
    private By phoneEmailField = By.id("connection-email");
    private By continueButton = By.xpath("//form[@id='pay-connection']//button[@type='submit']");
    private By paymentIframe = By.cssSelector("iframe.bepaid-iframe");

    // Methods
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void enterSumNumber(String sum) {
        driver.findElement(phoneSumField).sendKeys(sum);
    }

    public void enterEmail(String email) {
        driver.findElement(phoneEmailField).sendKeys(email);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public boolean isPaymentIframePresent() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(paymentIframe));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}