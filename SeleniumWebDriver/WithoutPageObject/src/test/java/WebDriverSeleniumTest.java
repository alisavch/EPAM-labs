import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class WebDriverSeleniumTest {
    private WebDriver driver;
    final WebElement actualNameWE = driver.findElement(By.xpath("//*[contains(@class, 'e5pihrt0')]"));
    final WebElement actualTitleWE = driver.findElement(By.xpath("//*[contains(@class, 'css-ommkxx')]"));
    final WebElement actualColourWE = driver.findElement(By.xpath("//*[contains(@class, 'css-ydoq90')]"));
    final WebElement actualSizeWE = driver.findElement(By.xpath("//*[@value='70a3beda-fc15-59f0-95e9-82d145240dd1']"));
    final WebElement actualPriceWE = driver.findElement(By.xpath("//*[contains(@class, 'ew71yvl1')]"));
    final WebElement actualCountWE = driver.findElement(By.xpath("//*[@value='1']"));


    final String actualName = actualNameWE.getText();
    final String actualTitle = actualTitleWE.getText();
    final String actualColour = actualColourWE.getText();
    final String actualSize = actualSizeWE.getText();
    final String actualPrice = actualPriceWE.getText();
    final String actualCount = actualCountWE.getText();

    @BeforeTest(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    public void addSneakersToCartTest() {
        driver.get("https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");
        driver.manage().window().maximize();

        WebElement closeLocation = waitForElementLocatedBy(driver, By.xpath("//i[@class='g72-x-circle fs32-nav-sm nav-color-black']"));
        closeLocation.click();
//        WebElement clickToClose = driver.findElement(By.xpath("//i[@class='g72-x-circle fs32-nav-sm']"));
//        clickToClose.click();
        List<WebElement> sizeBtn = driver.findElements(By.xpath("//label[@class='css-xf3ahq']"));
        sizeBtn.get(8).click();
        WebElement addToBag = waitForElementLocatedBy(driver, By.xpath("//button[contains(@class,'add-to-cart-btn')]"));
        addToBag.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//*[@id='nav-cart']/a")));
        WebElement cart = waitForElementLocatedBy(driver, By.xpath("//*[@id='nav-cart']/a"));
        cart.click();
        closeLocation.click(); }

    @Test
    public void verifyName() {
        Assert.assertEquals("Nike React Infinity Run Flyknit Premium", actualNameWE.getText());
    }
    @Test
    public void verifyTitle() {
        Assert.assertEquals("Женская беговая обувь", actualTitleWE.getText());
    }
    @Test
    public void verifyColour() {
        Assert.assertEquals("Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey", actualColourWE.getText());
    }
    @Test
    public void verifySize() {
        Assert.assertEquals("9 (RU 39,5)", actualSize);
    }
    @Test
    public void verifyPrice() {
        Assert.assertEquals("12 999,00 ₽", actualPrice);
    }
    @Test
    public void verifyCount() {
        Assert.assertEquals("1", actualCount);
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
