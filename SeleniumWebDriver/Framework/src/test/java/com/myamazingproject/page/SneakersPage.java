package com.myamazingproject.page;

import com.myamazingproject.model.SneakersSize;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SneakersPage extends Page {

    private final String SELECTSIZELOCATOR = "//div//label[normalize-space()='$']";

    @FindBy (xpath = "//div[@class='mb2-sm']//h1[@class='headline-2 css-zis9ta']")
    private WebElement nameSneakersLocator;

    @FindBy (xpath = "//div[@class='mb2-sm']//h2[@class='headline-5-small pb1-sm d-sm-ib css-1ppcdci'] ")
    private WebElement titleSneakersLocator;

    @FindBy (xpath = "//*[@class='mb2-sm']//*[@class='product-price is--current-price css-s56yt7']")
    private WebElement priceLocator;

    @FindBy (xpath = "//div[@id='floating-atc-wrapper']//button[contains(@class,'add-to-cart-btn')]")
    private WebElement addToCartLocator;

    @FindBy (xpath = "//*[@id='nav-cart']")
    private WebElement goToCartLocator;

    @FindBy (xpath = "//*[@class='g72-x bg-white p6-sm z10 modal-close-button']")
    private WebElement closeNotificationLocator;

    @FindBy (xpath = "//*[@class='css-bsyjwa e1n1kzst0']//*[@class='css-1brtky1 e1n1kzst1']")
    private WebElement errorLocator;

    public SneakersPage(WebDriver driver, String pageURL) {
        super(driver, pageURL);
    }

    public String getName(){
        return nameSneakersLocator.getText().trim();
    }

    public String getTitle() {
        return titleSneakersLocator.getText();
    }

    public String getPrice() {
        return priceLocator.getText();
    }

    public SneakersPage chooseSize(SneakersSize size) {
        waitForElementLocatedBy(driver, (WebElement) By.xpath(SELECTSIZELOCATOR
                .replace("$", size.getSize()))).click();
        return this;
    }

    public SneakersPage addToCart() {
        waitForElementLocatedBy(driver, addToCartLocator).click();
        return this;
    }

    public CartPage shoppingCart() {
        waitForElementLocatedBy(driver, goToCartLocator).click();
        return new CartPage(driver, pageURL);
    }

    public SneakersPage closeNotification() {
        waitForElementLocatedBy(driver,closeNotificationLocator).click();
        return this;
    }

    public static void getWarning(SneakersPage sneakersPage) {
        for (int i = 0; i <= 10; i++){
            sneakersPage.chooseSize(SneakersSize.US9)
                    .addToCart().closeNotification();
        }
    }

    public String getError(){
        return errorLocator.getText().trim();
    }
}
