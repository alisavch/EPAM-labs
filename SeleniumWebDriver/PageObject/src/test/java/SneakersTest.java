import model.Colour;
import model.ProductInfo;
import model.Size;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.CartPage;
import page.MainPage;
import page.SneakersPage;
import properties.ConfProperties;

import java.util.List;

public class SneakersTest {

    public static CartPage cartPage;
    public static MainPage mainPage;
    public static SneakersPage sneakersPage;
    public static WebDriver driver;

    private static final String inputSearch = "Nike React";
    private static final String expectedName = "Nike React Infinity Run Flyknit Premium";
    private static final String expectedTitle = "Женская беговая обувь";
    private static final String expectedColour = "Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey";
    private static final String expectedSize = "9 (RU 39,5)";
    private static final String expectedPrice ="10 480,00 ₽";
    private static final String expectedCount = "1";

    @BeforeSuite
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 0)
    public void findSneakersTest() {
        mainPage = new MainPage(driver);
        mainPage.clickClosePopUpWindow().closeWindow();
        sneakersPage = mainPage
                .clickSearchBtn(inputSearch)
                .clickToSearch()
                .clickFilter(Colour.purpe)
                .clickSneakers();
        Assert.assertEquals(sneakersPage.getTitle().trim(),expectedName);
    }

    @Test(priority = 1)
    public void addSneakersToCartTest() {
        SneakersPage sneakersPage = new SneakersPage(driver);
        sneakersPage.clickChooseSize(Size.US9)
                .clickAddToCart()
                .clickGoToCart();
        CartPage cartPage = new CartPage(driver);
        List<ProductInfo> productInfoList = cartPage.getInCartProductInfo();
        Assert.assertEquals(productInfoList.get(0).name, expectedName);
        Assert.assertEquals(productInfoList.get(0).title, expectedTitle);
        Assert.assertEquals(productInfoList.get(0).colour, expectedColour);
        Assert.assertEquals(productInfoList.get(0).size, expectedSize);
        Assert.assertEquals(productInfoList.get(0).price, expectedPrice);
        Assert.assertEquals(productInfoList.get(0).count, expectedCount);
    }

    @AfterSuite
    public static void tearDown() {
        driver.quit();
        driver = null;
    }

}