package page;

import model.Size;
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

public class SneakersPage extends Page {

    private final String selectSizeLocator = "//div//label[normalize-space()='$']";

    @FindBy(xpath = "//div[@class='mb2-sm']//h1[@class='headline-2 css-zis9ta']")
    private WebElement titleSneakers;

    private WebElement addToCart;

    private WebElement goToCart;

    public SneakersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 7), this);
    }

    public String getTitle() {
        return titleSneakers.getText();
    }

    public SneakersPage clickChooseSize(Size size) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement chooseSize = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectSizeLocator.replace("$", size.getSize()))));
        chooseSize.click();
        return this;
    }

    public SneakersPage clickAddToCart() {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        addToCart = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='floating-atc-wrapper']//button[contains(@class,'add-to-cart-btn')]")));
        addToCart.click();
        return this;
    }

    public CartPage clickGoToCart() {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
        goToCart = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav-cart']")));
        goToCart.click();
        return new CartPage(driver);
    }
}
