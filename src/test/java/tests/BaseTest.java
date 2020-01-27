package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import models.factories.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    AndroidDriver<MobileElement> driver;
    @BeforeTest
    public void setUp(){
        driver = DriverFactory.createDriver();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
