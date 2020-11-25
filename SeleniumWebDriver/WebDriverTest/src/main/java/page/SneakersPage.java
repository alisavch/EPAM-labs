package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SneakersPage {
    WebDriver driver;
    public SneakersPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        this.driver=driver;
    }

    @FindBy(xpath = "//i[@class='g72-x-circle fs32-nav-sm']")
    private WebElement closePopUpWindowLocation;

    @FindBy(xpath = "//*[contains(@for, 'skuAndSize__24898615')]")
    private WebElement chooseSize;

    @FindBy(xpath = "//button[contains(@class,'add-to-cart-btn')]")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@id='nav-cart']/a")
    private WebElement goToCart;


    public void clickClosePopUpWindow(){
        closePopUpWindowLocation.click();
    }

    public void clickChooseSize(){
        chooseSize.click();
    }
    public void clickAddToCart(){
        addToCart.click();
    }
    public void clickGoToCart(){
        goToCart.click();
    }
}
