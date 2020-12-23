package com.myamazingproject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUpWindow extends Page {

    private final Page previousPage;

    @FindBy (xpath = "//a[@title='Россия']")
    private WebElement closePopUpWindowLocation;

    public PopUpWindow(WebDriver driver, Page previousPage) {
        super(driver, previousPage.pageURL);
        this.previousPage = previousPage;
    }

    public MainPage selectCountry() {
        fluentWaitForElementLocatedBy(driver, closePopUpWindowLocation).click();
        return new MainPage(driver, previousPage.pageURL);
    }
}
