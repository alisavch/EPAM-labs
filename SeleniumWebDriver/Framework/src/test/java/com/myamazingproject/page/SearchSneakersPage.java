package com.myamazingproject.page;

import com.myamazingproject.model.Colour;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class SearchSneakersPage extends Page {

    private final String SELECTCOLOUR = "//button[normalize-space()='$']";

    @FindBy (xpath = "//div[@class='product-card css-1ikfoht css-z5nr6i css-11ziap1 css-zk7jxt css-dpr2cn product-grid__card ']//a[text()='Nike React Infinity Run Flyknit Premium']")
    private WebElement clickSneakersBtn;

    public SearchSneakersPage(WebDriver driver, String pageURL) {
        super(driver, pageURL);
    }

    public SearchSneakersPage filterColour(Colour colour) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement filterColour = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECTCOLOUR.replace("$", colour.getColour()))));
        filterColour.click();
        return this;
    }

    public SneakersPage selectSneakers() {
        clickSneakersBtn.click();
        return new SneakersPage(driver, pageURL);
    }
}
