package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import models.client.AppiumClient;

public class BasePage {
    private AppiumClient appiumClient;

    public BasePage() {
        this.appiumClient = new AppiumClient(this);
    }

    public AndroidDriver<MobileElement> getDriver() {
        return appiumClient.getDriver();
    }

    public AppiumClient getAppiumClient() {
        return appiumClient;
    }

}

