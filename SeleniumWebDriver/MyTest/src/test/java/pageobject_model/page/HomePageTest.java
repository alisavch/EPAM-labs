package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePageTest {
    public static SneakersPage sneakersPage;
    public static CartPage cartPage;
    public static WebDriver driver;

    @BeforeClass
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("homepage"));
        sneakersPage = new SneakersPage(driver);
        cartPage = new CartPage(driver);
    }
    public void addSneakers(){
        sneakersPage.clickClosePopUpWindow();
        sneakersPage.clickChooseSize();
        sneakersPage.clickAddToCart();
        sneakersPage.clickGoToCart();
        sneakersPage.clickClosePopUpWindow();
    }
    @Test
    public void checkNameText(){
        addSneakers();
        String actualName = cartPage.getName();
        Assert.assertEquals("Nike React Infinity Run Flyknit Premium", actualName);
    }
    @Test
    public void checkTitleTest(){
        addSneakers();
        String actualTitle = cartPage.getTitle();
        Assert.assertEquals("Женская беговая обувь", actualTitle);
    }

    @Test
    public void checkColourTest(){
        addSneakers();
        String actualColor = cartPage.getColour();
        Assert.assertEquals("Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey", actualColor);
    }

    @Test
    public void checkSizeTest(){
        addSneakers();
        String actualSize = cartPage.getSize();
        Assert.assertEquals("9 (RU 39,5)", actualSize);
    }

    @Test
    public void checkPriceTest(){
        addSneakers();
        String actualPrice = cartPage.getPrice();
        Assert.assertEquals("12 999,00 ₽", actualPrice);
    }

    @Test
    public void checkCountTest(){
        addSneakers();
        String actualCount = cartPage.getCount();
        Assert.assertEquals("1", actualCount);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
        driver = null;
    }
}
