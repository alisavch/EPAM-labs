package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import properties.ConfProperties;

public class MainPage extends Page {

    public MainPage(WebDriver driver){
        super(driver);
        driver.get(ConfProperties.getProperty("homepage"));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }
    @FindBy(xpath = "//a[@title='Россия']")
    private WebElement closePopUpWindowLocation;

    @FindBy(xpath = "//*[@data-var='closeBtn'] ")
    private WebElement closeNotif;

    @FindBy(xpath = "//*[@id='VisualSearchInput']")
    private WebElement searchBtn;

    @FindBy(xpath = "//*[@class='pre-search-btn ripple']")
    private WebElement clickToSearch;

    @FindBy(xpath = "//span[text()='Пурпурный'] ")
    private WebElement filterColor;

    @FindBy(xpath = "//a[@aria-label='Nike React Infinity Run Flyknit Premium']")
    private WebElement clickSneakers;

    public void clickClosePopUpWindow(){
        closePopUpWindowLocation.click();
    }
    public void clickCloseNotif(){
        closeNotif.click();
    }
    public void clickSearchBtn(){
        searchBtn.sendKeys("Nike React Infinity Run Flyknit Premium");
    }
    public void setClickToSearch(){
        clickToSearch.click();
    }
    public void clickFilter(){
        filterColor.click();
    }
    public void setClickSneakers(){
        clickSneakers.click();
    }
}
