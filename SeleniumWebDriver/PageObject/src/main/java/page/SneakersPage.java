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
import properties.ConfProperties;

import java.time.Duration;

public class SneakersPage extends Page {

    private final String SELECTSIZELOCATOR = "//div//label[normalize-space()='$']";

    @FindBy(xpath = "//div[@class='mb2-sm']//h1[@class='headline-2 css-zis9ta']")
    private WebElement nameSneakers;

    @FindBy(xpath = "//div[@class='mb2-sm']//h2[@class='headline-5-small pb1-sm d-sm-ib css-1ppcdci'] ")
    private WebElement titleSneakers;

    private WebElement chooseSize;

    private final By addToCartLocator = By.xpath("//div[@id='floating-atc-wrapper']//button[contains(@class,'add-to-cart-btn')]");

    private final By goToCartLocator = By.xpath("//*[@id='nav-cart']");

    public SneakersPage(WebDriver driver) {
        super(driver);
        driver.get(ConfProperties.getProperty("sneakerspage"));
    }

    public String getName(){
        return nameSneakers.getText();
    }

    public String getTitle() {
        return titleSneakers.getText();
    }

    public SneakersPage clickChooseSize(Size size) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        chooseSize = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECTSIZELOCATOR.replace("$", size.getSize()))));
        chooseSize.click();
        return this;
    }

    public SneakersPage clickAddToCart() {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement addToCart = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartLocator));
        addToCart.click();
        return this;
    }

    public CartPage clickGoToCart() {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement goToCart = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(goToCartLocator));
        goToCart.click();
        return new CartPage(driver);
    }
}
