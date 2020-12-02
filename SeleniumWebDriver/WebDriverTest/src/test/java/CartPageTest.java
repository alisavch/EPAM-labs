import model.Colour;
import model.ProductInfo;
import model.Size;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.*;
import properties.ConfProperties;

import java.util.List;

public class CartPageTest {

    public static MainPage mainPage;
    public static SneakersPage sneakersPage;
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
        sneakersPage = mainPage
                .closeNotif()
                .clickSearchBtn(inputSearch)
                .clickToSearch()
                .clickFilter(Colour.purpe)
                .clickSneakers();
        Assert.assertEquals(sneakersPage.getTitle().trim(),"Nike React Infinity Run Flyknit Premium");
    }

    @Test
    public void checkParametersText() {
        mainPage = new MainPage(driver);
        mainPage.clickClosePopUpWindow().closeWindow();
        sneakersPage = mainPage
                .closeNotif()
                .clickSearchBtn(inputSearch)
                .clickToSearch()
                .clickFilter(Colour.purpe)
                .clickSneakers();
        sneakersPage.clickChooseSize(Size.US9)
                .clickAddToCart()
                .clickGoToCart();
        CartPage cartPage = new CartPage(driver);
        List<ProductInfo> productInfoList = cartPage.getInCartProductInfo();
        Assert.assertEquals(productInfoList.get(0).name, "Nike React Infinity Run Flyknit Premium");
        Assert.assertEquals(productInfoList.get(0).title, "Женская беговая обувь");
    }

    @AfterTest
    public static void tearDown() {
        driver.quit();
        driver = null;
    }

}
