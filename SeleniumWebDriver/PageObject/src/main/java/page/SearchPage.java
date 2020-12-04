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
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    private final String BTNFILTERCOLOUR = "//button[normalize-space()='$']";

    private WebElement filterColour;

    private WebElement subscribe;

    @FindBy (xpath = "//div[@class='product-card css-1ikfoht css-z5nr6i css-11ziap1 css-zk7jxt css-dpr2cn product-grid__card ']//a[text()='Nike React Infinity Run Flyknit Premium']")
    private WebElement clickSneakersBtn;

    public SearchPage clickFilter(Colour colour) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        filterColour = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BTNFILTERCOLOUR.replace("$", colour.getColour()))));
        filterColour.click();
        return this;
    }

    public SearchPage clickSubscribe(){
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        subscribe = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='bluecoreCloseButton']")));
        subscribe.click();
        return this;
    }

    public SneakersPage clickSneakers() {
        clickSneakersBtn.click();
        return new SneakersPage(driver);
    }
}
