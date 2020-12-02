package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PopUpWindow extends Page{

    private final Page previousPage;

    @FindBy(xpath = "//a[@title='Россия']")
    private WebElement closePopUpWindowLocation;

    public PopUpWindow(WebDriver driver, Page previousPage) {
        super(driver);
        this.previousPage = previousPage;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    public Page closeWindow() {
        closePopUpWindowLocation.click();
        return this.previousPage;
    }

}
