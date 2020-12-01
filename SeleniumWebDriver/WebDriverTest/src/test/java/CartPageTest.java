import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.reporters.jq.Main;
import page.CartPage;
import page.SneakersPage;
import page.MainPage;
import properties.ConfProperties;

public class CartPageTest {
    public  static MainPage mainPage;
    public static SneakersPage sneakersPage;
    public static CartPage cartPage;
    public static WebDriver driver;

    @BeforeTest
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @Test
    public void findSneakersTest(){
        mainPage = new MainPage(driver);
        sneakersPage = new SneakersPage(driver);
        mainPage.clickClosePopUpWindow();
        mainPage.clickSearchBtn();
        mainPage.setClickToSearch();
//        mainPage.clickCloseNotif();
        mainPage.clickFilter();
        mainPage.setClickSneakers();
        Assert.assertEquals("Женская беговая обувь", sneakersPage.getCategory().trim());
        Assert.assertEquals("Nike React Infinity Run Flyknit Premium", sneakersPage.getTitle().trim());
    }
    @Test
    public void checkParametersText(){
        sneakersPage = new SneakersPage(driver);
        cartPage = new CartPage(driver);
        sneakersPage.clickChooseSize();
        sneakersPage.clickAddToCart();
        sneakersPage.clickGoToCart();
        Assert.assertEquals("Nike React Infinity Run Flyknit Premium", cartPage.getName().trim());
        Assert.assertEquals("Женская беговая обувь", cartPage.getTitle().trim());
        Assert.assertEquals("Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey", cartPage.getColour().trim());
        Assert.assertEquals("9 (RU 39,5)", cartPage.getSize().trim());
//        Assert.assertEquals("12 999,00 ₽", cartPage.getPrice().trim());
        Assert.assertEquals("1", cartPage.getCount().trim());

    }

    @AfterTest
    public static void tearDown(){
        driver.quit();
        driver = null;
    }
}
