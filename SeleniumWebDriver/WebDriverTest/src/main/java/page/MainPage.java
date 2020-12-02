package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import properties.ConfProperties;

public class MainPage extends Page {

    @FindBy(xpath = "//*[@id='VisualSearchInput']")
    private WebElement searchBtn;

    @FindBy(xpath = "//*[@class='pre-search-btn ripple']")
    private WebElement clickToSearchBtn;

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get(ConfProperties.getProperty("homepage"));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
    }

    public PopUpWindow clickClosePopUpWindow() {
        return new PopUpWindow(driver, this);
    }

    public MainPage clickSearchBtn(String search) {
        searchBtn.sendKeys(search);
        return this;
    }

    public MainPage clickToSearch() {
        clickToSearchBtn.click();
        return this;
    }

}
