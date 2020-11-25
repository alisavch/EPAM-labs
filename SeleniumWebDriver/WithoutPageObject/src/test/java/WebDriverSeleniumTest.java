import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverSeleniumTest extends WebDriverSelenium{

    @BeforeTest
    public void setUp(){
        initialization();
    }

    @Test
    public void verifyNameTest() {
        Assert.assertEquals("Nike React Infinity Run Flyknit Premium", actualNameWE.getText().trim());
    }
    @Test
    public void verifyTitleTest() {
        Assert.assertEquals("Женская беговая обувь", actualTitleWE.getText().trim());
    }
    @Test
    public void verifyColourTest() {
        Assert.assertEquals("Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey", actualColourWE.getText().trim());
    }
    @Test
    public void verifySizeTest() {
        Assert.assertEquals("9 (RU 39,5)", actualSizeWE.getText().trim());
    }
//    @Test
//    public void verifyPriceTest() {
//        Assert.assertEquals("12 999,00 ₽", actualPriceWE.getText().trim());
//    }
    @Test
    public void verifyCountTest() {
        Assert.assertEquals("1", actualCountWE.getText().trim());
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
