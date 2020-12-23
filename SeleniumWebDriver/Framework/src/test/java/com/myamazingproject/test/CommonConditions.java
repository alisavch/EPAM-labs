package com.myamazingproject.test;

import com.myamazingproject.driver.DriverSingleton;
import com.myamazingproject.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeClass()
    public void setUp() {
        driver = DriverSingleton.getDriver();
        DriverSingleton.deleteAllCookies();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}

