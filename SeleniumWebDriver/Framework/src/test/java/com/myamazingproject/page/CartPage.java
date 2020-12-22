package com.myamazingproject.page;

import com.myamazingproject.model.SneakersInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CartPage extends  Page {

    @FindBy (xpath = "//*[@class='css-4igyh0 e1pfgppp2'][@name='remove-item-button']")
    private WebElement removeFromCartLocator;

    @FindBy (xpath = "//*[@class='css-b2zj1a edp6lpb0']")
    private WebElement emptyCartLocator;

    @FindBy (xpath = "//*[@class='ncss-col-sm-6']//*[@class='price css-1uihcua ew71yvl1']")
    private WebElement finalPriceLocator;

    @FindBy (xpath = "//*[@class='css-10ct45e e1pfgppp1']//*[text()='Перенести в избранное']")
    private WebElement favoriteLocator;

    @FindBy (xpath = "//*[@class='unite-container']//*[@class='view-header']")
    private WebElement signInLocator;

    @FindBy (xpath = "//*[contains(@class,'css-gajhq5')]//*[text()='Оформить заказ без регистрации']")
    private WebElement checkoutWithoutRegisterLocator;

    public CartPage(WebDriver driver, String pageURL) {
        super(driver, pageURL);
    }

    public CartPage removeFromCart() {
        waitForElementLocatedBy(driver, removeFromCartLocator).click();
        return this;
    }

    public String emptyCart() {
        return emptyCartLocator.getText().trim();
    }

    public String getPrice() {
        return waitForElementLocatedBy(driver,finalPriceLocator).getText().trim();
    }

    public CartPage addToFavourite() {
        waitForElementLocatedBy(driver,favoriteLocator).click();
        return this;
    }

    public CartPage popUpSignIn() {
        waitForElementLocatedBy(driver,signInLocator).getText();
        return this;
    }

    public OrderPage checkoutWithoutRegister() {
        waitForElementLocatedBy(driver, checkoutWithoutRegisterLocator).click();
        return new OrderPage(driver, pageURL);
    }

    public List<SneakersInfo> getInCartProductInfo() {
        By productsInfoLocator = By.xpath("//*[@class='css-1930mmg ezer4f61']");
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        List<WebElement> productsInfo = (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productsInfoLocator));

        List<SneakersInfo> productInfoList = new ArrayList<SneakersInfo>();
        for(WebElement productInfo : productsInfo) {
            String name = productInfo.findElement(By.xpath("//*[contains(@class, 'e5pihrt0')]")).getText().trim();
            String title = productInfo.findElement(By.xpath("//*[contains(@class, 'css-ommkxx')]")).getText().trim();;
            String colour = productInfo.findElement(By.xpath("//*[contains(@class, 'css-ydoq90')]")).getText().trim();;
            String price = productInfo.findElement(By.xpath("//*[@class='ncss-row']//*[@class='price css-1uihcua ew71yvl1']")).getText().trim();;
            String size = null;
            if(productInfo.findElements(By.xpath("//*[@class='css-w53gby e4f9riy4'][@data-automation='size-select']")).size() > 0){
                size = productInfo.findElement(By.xpath("//option[@value='70a3beda-fc15-59f0-95e9-82d145240dd1']")).getText().trim();
            }
            String count = null;
            if(productInfo.findElements(By.xpath("//*[@class='css-w53gby e4f9riy4'][@data-automation='quantity-select']")).size() > 0) {
                count = productInfo.findElement(By.xpath("//option[@value='1']")).getText().trim();
            }
            productInfoList.add(new SneakersInfo(name, title, colour, size, price, count));
        }
        return productInfoList;
    }
}
