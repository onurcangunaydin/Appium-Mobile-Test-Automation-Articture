package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import models.factories.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementFinder {

    protected AndroidDriver<MobileElement> driver;

    public ElementFinder() {
        driver = DriverFactory.getInstance();
    }

    protected AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    protected MobileElement waitUntilClickable(By by) {
        MobileElement mobileElement = driver.findElement(by);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(mobileElement));
        return mobileElement;
    }

    protected MobileElement waitUntilClickable(MobileElement mobileElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(mobileElement));
        return mobileElement;
    }

    protected MobileElement waitUntilVisibility(By by, int timeoutDuration) {
        MobileElement mobileElement = driver.findElement(by);
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutDuration);
        webDriverWait.until(ExpectedConditions.visibilityOf(mobileElement));
        return mobileElement;
    }


    public boolean isElementVisible(By by, int timeoutDuration) {
        return waitUntilVisibility(by, timeoutDuration).isDisplayed();
    }

    public boolean isElementVisible(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public boolean doesTextAppearInsideLocator(By by, String text) {
        MobileElement element = waitForText(by, text);
        return element.getText().contentEquals(text);
    }

    public MobileElement waitForText(By by, String text) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
        return driver.findElement(by);
    }

    public void waitUntilElementToBeHidden(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }

    public void waitUntilElementToBeVisible(By by, int timeoutDuration) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutDuration);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public boolean isTextVisibleInsidePageSource(String message) {
        return driver.getPageSource().contains(message);
    }


    public void waitForLoaders() {
        waitUntilElementToBeHidden(MobileBy.id("login_progress"));
        waitUntilElementToBeHidden(MobileBy.id("categories_progress"));
        waitUntilElementToBeHidden(MobileBy.id("products_progress"));
    }
}
