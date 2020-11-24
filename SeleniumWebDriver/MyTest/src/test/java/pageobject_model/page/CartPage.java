package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    public WebDriver driver;
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'e5pihrt0')]")
    private WebElement actualNameWE;

    @FindBy(xpath = "//*[contains(@class, 'css-ommkxx')]")
    private WebElement actualTitleWE;

    @FindBy(xpath = "//*[contains(@class, 'css-ydoq90')]")
    private WebElement actualColourWE;

    @FindBy(xpath = "//*[@value='70a3beda-fc15-59f0-95e9-82d145240dd1']")
    private WebElement actualSizeWE;

    @FindBy(xpath = "//*[contains(@class, 'ew71yvl1')]")
    private WebElement actualPriceWE;

    @FindBy(xpath = "//*[@value='1']")
    private WebElement actualCountWE;

    public String getName(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'e5pihrt0')]")));
        return actualNameWE.getText();
    }
    public String getTitle(){
        return actualTitleWE.getText();
    }
    public String getColour(){
        return actualColourWE.getText();
    }
    public String getSize(){
        return actualSizeWE.getText();
    }
    public String getPrice(){
        return actualPriceWE.getText();
    }
    public String getCount(){
        return actualCountWE.getText();
    }
}
