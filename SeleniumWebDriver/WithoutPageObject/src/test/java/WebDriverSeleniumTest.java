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
        Assert.assertEquals("Nike React Infinity Run Flyknit Premium", actualNameWE.getText().trim());
    }
    @Test
    public void verifyTitle() {
        WebElement actualTitleWE = driver.findElement(By.xpath("//*[contains(@class, 'css-ommkxx')]"));
        Assert.assertEquals("Женская беговая обувь", actualTitleWE.getText().trim());
    }
    @Test
    public void verifyColour() {
        WebElement actualColourWE = driver.findElement(By.xpath("//*[contains(@class, 'css-ydoq90')]"));
        Assert.assertEquals("Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey", actualColourWE.getText().trim());
    }
//    @Test
//    public void verifySize() {
//        WebElement actualSizeWE = driver.findElement(By.xpath("//*[@value='70a3beda-fc15-59f0-95e9-82d145240dd1']"));
//        Assert.assertEquals("9 (RU 39,5)", actualSizeWE.getText().trim());
//    }
//    @Test
//    public void verifyPrice() {
//        WebElement actualPriceWE = driver.findElement(By.xpath("//*[contains(@class, 'ew71yvl1')]"));
//        Assert.assertEquals("12 999,00 ₽", actualPriceWE.getText().trim());
//    }
//    @Test
//    public void verifyCount() {
//        WebElement actualCountWE = driver.findElement(By.xpath("//*[@value='1']"));
//        Assert.assertEquals("1", actualCountWE.getText().trim());
//    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
