package models.client;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.ElementFinder;

public class AppiumClient extends ElementFinder {
    private BasePage basePage;

    public <T extends BasePage> AppiumClient(T basePage) {
        super();
        this.basePage = basePage;
    }

    public void fillTextBox(By by, String keyword) {
        driver.findElement(by).sendKeys(keyword);

    }

    public void click(By by) {
        waitUntilClickable(by).click();
        waitForLoaders();
    }

    public void click(MobileElement mobileElement) {
        waitUntilClickable(mobileElement).click();
        waitForLoaders();

    }
}
