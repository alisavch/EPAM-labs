import model.Colour;
import model.ProductInfo;
import model.Size;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.reporters.jq.Main;
import page.*;
import properties.ConfProperties;

import java.util.List;

public class CartPageTest {

    public  static MainPage mainPage;
    public static SearchPage searchPage;
    public static SneakersPage sneakersPage;
    public static PopUpWindow popUpWindow;
    public static CartPage cartPage;
    public static WebDriver driver;

    private static final String inputSearch = "Nike React Infinity Run Flyknit";

    @BeforeTest
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void findSneakersTest() {
        mainPage = new MainPage(driver);
        mainPage.clickClosePopUpWindow().closeWindow();
        mainPage.clickSearchBtn(inputSearch)
                .clickToSearch();
        searchPage.clickFilter(Colour.purpe)
                .clickSneakers();
        sneakersPage.getCategory();
        Assert.assertEquals("Женская беговая обувь", sneakersPage.getCategory().trim());
    }

    @Test
    public void checkParametersText() {
        ProductInfo sneakers = new ProductInfo("Nike React Infinity Run Flyknit Premium", "Женская беговая обувь", "Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey", "9 (RU 39,5)", "12 999,0 ₽", "1");
        sneakersPage.clickChooseSize(Size.US9)
                .clickAddToCart()
                .clickGoToCart();
        List<ProductInfo> productInfoList = cartPage.getInCartProductInfo();
        Assert.assertEquals(productInfoList.get(0).name, "Nike React Infinity Run Flyknit Premium");
        Assert.assertEquals(productInfoList.get(0).title, "Женская беговая обувь");
        Assert.assertEquals(productInfoList.get(0).colour, "");
    }

    @AfterTest
    public static void tearDown() {
        driver.quit();
        driver = null;
    }

}
