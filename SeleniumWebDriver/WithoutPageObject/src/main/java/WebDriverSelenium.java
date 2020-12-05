import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSelenium {

    public static WebDriver driver;
    public static WebElement actualNameWE;
    public static WebElement actualTitleWE;
    public static WebElement actualColourWE;
    public static WebElement actualSizeWE;
    public static WebElement actualCountWE;

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 40)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void initialization() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        WebElement closeLocation = waitForElementLocatedBy(driver, By.xpath("//i[@class='g72-x-circle fs32-nav-sm nav-color-black']"));
        closeLocation.click();
        WebElement sizeBtn = driver.findElement(By.xpath("//div//label[normalize-space()='US 9 (RU 39,5)']"));
        sizeBtn.click();
        WebElement addToBag = waitForElementLocatedBy(driver, By.xpath("//div[@id='floating-atc-wrapper']//button[contains(@class,'add-to-cart-btn')]"));
        addToBag.click();
        WebElement cart = waitForElementLocatedBy(driver, By.xpath("//*[@id='nav-cart']"));
        cart.click();
        WebElement closeLocation2 = waitForElementLocatedBy(driver, By.xpath("//*[@class='g72-x-circle fs32-nav-sm nav-color-black']"));
        closeLocation2.click();

        actualNameWE = waitForElementLocatedBy(driver, By.xpath("//*[contains(@class, 'e5pihrt0')]"));
        actualTitleWE = waitForElementLocatedBy(driver, By.xpath("//*[contains(@class, 'css-ommkxx')]"));
        actualColourWE = waitForElementLocatedBy(driver, By.xpath("//*[contains(@class, 'css-ydoq90')]"));
        actualSizeWE = waitForElementLocatedBy(driver, By.xpath("//*[@value='70a3beda-fc15-59f0-95e9-82d145240dd1']"));
        actualCountWE = waitForElementLocatedBy(driver,By.xpath("//*[@value='1']"));
    }
}