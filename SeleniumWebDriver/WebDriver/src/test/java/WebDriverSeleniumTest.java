import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverSeleniumTest extends WebDriverSelenium {

    @BeforeTest
    public void setUp() {
        initialization();
    }

    @Test
    public void verifyTest() {
        Assert.assertEquals("Nike React Infinity Run Flyknit Premium", actualNameWE.getText().trim());
        Assert.assertEquals("Женская беговая обувь", actualTitleWE.getText().trim());
        Assert.assertEquals("Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey", actualColourWE.getText().trim());
        Assert.assertEquals("9 (RU 39,5)", actualSizeWE.getText().trim());
        Assert.assertEquals("1", actualCountWE.getText().trim());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
