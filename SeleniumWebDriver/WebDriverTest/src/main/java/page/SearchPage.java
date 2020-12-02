package page;

import model.Colour;
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

import java.time.Duration;

public class SearchPage extends Page {

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 7), this);
    }

    private final String btnFilterColour = "//button[normalize-space()='$']";

    @FindBy(xpath = "//a[@aria-label='Nike React Infinity Run Flyknit Premium']")
    private WebElement clickSneakersBtn;

    public SearchPage clickFilter(Colour colour) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement filterColour = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnFilterColour.replace("$", colour.getColour()))));
        filterColour.click();
        return this;
    }

    public SneakersPage clickSneakers() {
        clickSneakersBtn.click();
        return new SneakersPage(driver);
    }
}
