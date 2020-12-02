package page;

import model.Colour;
import model.Size;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchPage extends Page {

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//a[@aria-label='Nike React Infinity Run Flyknit Premium']")
    private WebElement clickSneakersBtn;

    private final String btnFilterColour = "//button[normalize-space()='$']";

    public SearchPage clickFilter(Colour colour) {
        WebElement filterColour = driver.findElement(By.xpath(btnFilterColour.replace("$", colour.getColour())));
        filterColour.click();
        return this;
    }

    public SearchPage clickSneakers() {
        clickSneakersBtn.click();
        return this;
    }
}
