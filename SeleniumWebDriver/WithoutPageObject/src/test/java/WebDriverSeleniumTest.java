import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverSeleniumTest extends WebDriverSelenium{
    public static WebDriver driver;
    private final WebElement actualNameWE = driver.findElement(By.xpath("//*[contains(@class, 'e5pihrt0')]"));
    private final WebElement actualTitleWE = driver.findElement(By.xpath("//*[contains(@class, 'css-ommkxx')]"));
    private final WebElement actualColourWE = driver.findElement(By.xpath("//*[contains(@class, 'css-ydoq90')]"));
    private final WebElement actualSizeWE = driver.findElement(By.xpath("//*[@value='70a3beda-fc15-59f0-95e9-82d145240dd1']"));
    private final WebElement actualPriceWE = driver.findElement(By.xpath("//*[contains(@class, 'ew71yvl1')]"));
    private final WebElement actualCountWE = driver.findElement(By.xpath("//*[@value='1']"));

    @BeforeTest
    public void setUp(){
        initialization();
    }

    @Test
    public void verifyName() {
        Assert.assertEquals("Nike React Infinity Run Flyknit Premium", actualNameWE.getText().trim());
    }
    @Test
    public void verifyTitle() {
        Assert.assertEquals("Женская беговая обувь", actualTitleWE.getText().trim());
    }
    @Test
    public void verifyColour() {
        Assert.assertEquals("Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey", actualColourWE.getText().trim());
    }
//    @Test
//    public void verifySize() {
//        Assert.assertEquals("9 (RU 39,5)", actualSizeWE.getText().trim());
//    }
//    @Test
//    public void verifyPrice() {
//        Assert.assertEquals("12 999,00 ₽", actualPriceWE.getText().trim());
//    }
//    @Test
//    public void verifyCount() {
//        Assert.assertEquals("1", actualCountWE.getText().trim());
//    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
