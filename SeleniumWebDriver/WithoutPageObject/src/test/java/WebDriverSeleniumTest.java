import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverSeleniumTest extends WebDriverSelenium{
    public static WebDriver driver;

    @BeforeTest
    public void setUp(){
        initialization();
    }

    @Test
    public void verifyName() {
        WebElement actualNameWE = driver.findElement(By.xpath("//*[contains(@class, 'e5pihrt0')]"));
        String actualName = actualNameWE.getText();
        Assert.assertEquals("Nike React Infinity Run Flyknit Premium", actualName);
    }
    @Test
    public void verifyTitle() {
        WebElement actualTitleWE = driver.findElement(By.xpath("//*[contains(@class, 'css-ommkxx')]"));
        String actualTitle = actualTitleWE.getText();
        Assert.assertEquals("Женская беговая обувь", actualTitle);
    }
    @Test
    public void verifyColour() {
        WebElement actualColourWE = driver.findElement(By.xpath("//*[contains(@class, 'css-ydoq90')]"));
        String actualColour = actualColourWE.getText();
        Assert.assertEquals("Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey", actualColour);
    }
//    @Test
//    public void verifySize() {
//        WebElement actualSizeWE = driver.findElement(By.xpath("//*[@value='70a3beda-fc15-59f0-95e9-82d145240dd1']"));
//        String actualSize = actualSizeWE.getText();
//        Assert.assertEquals("9 (RU 39,5)", actualSize);
//    }
//    @Test
//    public void verifyPrice() {
//        WebElement actualPriceWE = driver.findElement(By.xpath("//*[contains(@class, 'ew71yvl1')]"));
//        String actualPrice = actualPriceWE.getText();
//        Assert.assertEquals("12 999,00 ₽", actualPrice);
//    }
//    @Test
//    public void verifyCount() {
//        WebElement actualCountWE = driver.findElement(By.xpath("//*[@value='1']"));
//        String actualCount = actualCountWE.getText();
//        Assert.assertEquals("1", actualCount);
//    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
