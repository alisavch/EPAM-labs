import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSelenium {

    public static void initialization(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");
        driver.manage().window().maximize();

        WebElement closeLocation = waitForElementLocatedBy(driver, By.xpath("//i[@class='g72-x-circle fs32-nav-sm nav-color-black']"));
        closeLocation.click();
//      WebElement clickToClose = driver.findElement(By.xpath("//i[@class='g72-x-circle fs32-nav-sm']"));
//      clickToClose.click();
        WebElement sizeBtn = driver.findElement(By.xpath("//*[contains(@for, 'skuAndSize__24898615')]"));
        sizeBtn.click();
        WebElement addToBag = waitForElementLocatedBy(driver, By.xpath("//*[contains(@class,'add-to-cart-btn')]"));
        addToBag.click();
        WebElement cart = waitForElementLocatedBy(driver, By.xpath("//*[@id='nav-cart']/a"));
        cart.click();
        closeLocation.click();
    }
    private static WebElement waitForElementLocatedBy(org.openqa.selenium.WebDriver driver, By by) {
        return new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}