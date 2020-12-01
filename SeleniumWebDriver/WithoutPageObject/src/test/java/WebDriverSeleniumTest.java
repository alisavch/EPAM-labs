import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverSeleniumTest extends WebDriverSelenium{

//    @BeforeTest
//    public void setUp(){
//
//    }

    @Test
    public void verifyTest() {
        initialization();
        Assert.assertEquals("Nike React Infinity Run Flyknit Premium", actualNameWE.getText().trim());
        Assert.assertEquals("Женская беговая обувь", actualTitleWE.getText().trim());
        Assert.assertEquals("Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey", actualColourWE.getText().trim());
        Assert.assertEquals("9 (RU 39,5)", actualSizeWE.getText().trim());
//        Assert.assertEquals("12 999,00 ₽", actualPriceWE.getText().trim());
        Assert.assertEquals("1", actualCountWE.getText().trim());
        driver.quit();
    }

//    @AfterTest
//    public void tearDown(){
//
//    }

}
