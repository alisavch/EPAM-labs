import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.CartPage;
import page.SneakersPage;
import properties.ConfProperties;

import java.util.concurrent.TimeUnit;

public class CartPageTest {
    public static SneakersPage sneakersPage;
    public static CartPage cartPage;
    public static WebDriver driver;

    @BeforeTest
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("homepage"));
        sneakersPage = new SneakersPage(driver);
        cartPage = new CartPage(driver);
//      sneakersPage.clickLocation();
        sneakersPage.clickClosePopUpWindow();
        sneakersPage.clickChooseSize();
        sneakersPage.clickAddToCart();
        sneakersPage.clickGoToCart();
//      sneakersPage.clickClosePopUpWindow();
    }
    @Test
    public void checkNameText(){
        Assert.assertEquals("Nike React Infinity Run Flyknit Premium", cartPage.getName().trim());
    }
    @Test
    public void checkTitleTest(){
        Assert.assertEquals("Женская беговая обувь", cartPage.getTitle().trim());
    }

    @Test
    public void checkColourTest(){
        Assert.assertEquals("Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey", cartPage.getColour().trim());
    }

    @Test
    public void checkSizeTest(){
        Assert.assertEquals("9 (RU 39,5)", cartPage.getSize().trim());
    }

//    @Test
//    public void checkPriceTest(){
//        Assert.assertEquals("12 999,00 ₽", cartPage.getPrice().trim());
//    }

    @Test
    public void checkCountTest(){
        Assert.assertEquals("1", cartPage.getCount().trim());
    }

    @AfterTest
    public static void tearDown(){
        driver.quit();
        driver = null;
    }
}
