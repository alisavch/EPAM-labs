package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import properties.ConfProperties;

import java.time.Duration;

public class MainPage extends Page {

    private WebElement searchBtn;

    @FindBy(xpath = "//*[@class='pre-search-btn ripple']")
    private WebElement clickToSearchBtn;

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get(ConfProperties.getProperty("homepage"));
    }

    public PopUpWindow clickClosePopUpWindow() {
        return new PopUpWindow(driver, this);
    }

    public MainPage clickSearchBtn(String search) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        searchBtn = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='VisualSearchInput']")));
        searchBtn.sendKeys(search);
        return this;
    }

    public SearchPage clickToSearch() {
        clickToSearchBtn.click();
        return new SearchPage(driver);
    }
}