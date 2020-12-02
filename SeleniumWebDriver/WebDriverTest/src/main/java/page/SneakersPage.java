package page;

import model.Size;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SneakersPage extends Page {

    @FindBy(css = "div.pr2-sm css-1ou6bb2 h2.headline-5-small pb1-sm d-sm-ib css-1ppcdci")
    private WebElement categorySneakers;

    @FindBy(css = "div.pr2-sm css-1ou6bb2 h2.headline-2 css-zis9ta")
    private WebElement titleSneakers;

    @FindBy(xpath = "//button[contains(@class,'add-to-cart-btn')]")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@id='nav-cart']/a")
    private WebElement goToCart;

    public SneakersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    public String getCategory() {
        return categorySneakers.getText();
    }

    public String getTitle() {
        return titleSneakers.getText();
    }

    public SneakersPage clickChooseSize(Size size) {
        String selectSizeLocator = "//label[normalize-space()='US 9 $'] ";
        WebElement chooseSize = driver.findElement(By.xpath(selectSizeLocator.replace("$", size.getSize())));
        chooseSize.click();
        return this;
    }

    public SneakersPage clickAddToCart() {
        addToCart.click();
        return this;
    }

    public SneakersPage clickGoToCart() {
        goToCart.click();
        return this;
    }
}
