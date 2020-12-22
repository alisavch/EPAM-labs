package com.myamazingproject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

    @FindBy (xpath = "//*[@id='VisualSearchInput']")
    private WebElement entryFieldLocator;

    @FindBy (xpath = "//*[@class='pre-search-btn ripple']")
    private WebElement searchButtonLocator;

    @FindBy (xpath = "//*[@aria-label='Женщины']")
    private WebElement womenMenuLocator;

    public MainPage(WebDriver driver, String pageURL) {
        super(driver, pageURL);
    }

    public PopUpWindow popUpWindow() {
        return new PopUpWindow(driver, this);
    }

    public MainPage inputValueToSearch(String search) {
        waitForElementLocatedBy(driver, entryFieldLocator).sendKeys(search);
        return this;
    }

    public SearchSneakersPage search() {
        searchButtonLocator.click();
        return new SearchSneakersPage(driver, pageURL);
    }

    public SearchClothesPage selectWomen() {
        womenMenuLocator.click();
        return new SearchClothesPage(driver, pageURL);
    }
}
