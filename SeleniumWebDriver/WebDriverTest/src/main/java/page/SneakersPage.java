package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SneakersPage extends Page{

    public SneakersPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
    }
    @FindBy(xpath = "//*[@id='RightRail']/div/div[1]/div/div[1]/div[1]/h2")
    private WebElement categorySneakers;

    @FindBy(xpath = "//*[@id='RightRail']/div/div[1]/div/div[1]/div[1]/h1")
    private WebElement titleSneakers;

    @FindBy(xpath = "//*[contains(@for, 'skuAndSize__24898615')]")
    private WebElement chooseSize;

    @FindBy(xpath = "//button[contains(@class,'add-to-cart-btn')]")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@id='nav-cart']/a")
    private WebElement goToCart;

    public String getCategory(){
        return categorySneakers.getText();
    }
    public String getTitle(){
        return titleSneakers.getText();
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
