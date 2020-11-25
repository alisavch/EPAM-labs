package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SneakersPage {
    WebDriver driver;
    public SneakersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }
    ////i[@class='g72-x-circle fs32-nav-sm nav-color-black']
    //xpath = "//i[@class='g72-x-circle fs32-nav-sm']"
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
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='css-xf3ahq'][text()='US 9 (RU 39,5)']")));
        chooseSize.click();
    }
    public void clickAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'add-to-cart-btn')]")));
        addToCart.click();
    }
    public void clickGoToCart(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav-cart']/a")));
        goToCart.click();
    }

}
