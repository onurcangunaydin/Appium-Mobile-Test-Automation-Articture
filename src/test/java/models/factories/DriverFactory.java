package models.factories;

import constants.DeviceCapabilites;
import helpers.PropertiesHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static AndroidDriver<MobileElement> driver;
    private static URL driverUrl;
    private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities(DeviceCapabilites.PIXEL_2_CAPABILITIES);

    public static AndroidDriver<MobileElement> createDriver() {
        try {
            driverUrl = new URL(PropertiesHelper.getProperty("appium-url"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (driver == null) {
            driver = new AndroidDriver<>(driverUrl, desiredCapabilities);
        }
        return driver;
    }

    public static AndroidDriver<MobileElement> getInstance() {
        return driver;
    }

}

