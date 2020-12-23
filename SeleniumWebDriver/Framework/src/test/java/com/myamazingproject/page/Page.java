package com.myamazingproject.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class Page {

    protected final int WAIT_TIMEOUT_SECONDS = 60;

    protected final WebDriver driver;
    protected String pageURL;

    public Page(WebDriver driver, String pageURL) {
        this.driver = driver;
        this.pageURL = pageURL;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    public Page openPage() {
        this.driver.get(this.pageURL);
        this.driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return this;
    }

    protected static WebElement waitForElementLocatedBy(WebDriver driver, WebElement by) {
        return new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(by));
    }

    protected static WebElement fluentWaitForElementLocatedBy(WebDriver driver, WebElement by) {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class).until((ExpectedConditions.visibilityOf(by)));
    }

    protected static WebElement fluentWaitForElementToBeClickable(WebDriver driver, WebElement by) {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class).until((ExpectedConditions.elementToBeClickable(by)));
    }
}

