package com.myamazingproject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        waitUntilAjaxCompleted();
        return this;
    }

    protected static WebElement waitForElementLocatedBy(WebDriver driver, WebElement by) {
        return new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated((By) by));
    }

    public void waitUntilAjaxCompleted() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
    }

    protected static ExpectedCondition<Boolean> jQueryAJAXCompleted() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver){
                return (Boolean) ((JavascriptExecutor)
                        driver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };
    }
}

