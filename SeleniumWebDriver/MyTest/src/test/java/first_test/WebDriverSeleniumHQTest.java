package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class WebDriverSeleniumHQTest {

    @Test
    public void addSneakersToCartTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");
        driver.manage().window().maximize();

        WebElement closeLocation = waitForElementLocatedBy(driver, By.xpath("//i[@class='g72-x-circle fs32-nav-sm nav-color-black']"));
        closeLocation.click();
//        WebElement clickToClose = driver.findElement(By.xpath("//i[@class='g72-x-circle fs32-nav-sm']"));
//        clickToClose.click();
        List<WebElement> sizeBtn = driver.findElements(By.xpath("//label[@class='css-xf3ahq']"));
        sizeBtn.get(8).click();
        WebElement addToBag = waitForElementLocatedBy(driver, By.xpath("//button[contains(@class,'add-to-cart-btn')]"));
        addToBag.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//*[@id='nav-cart']/a")));
        WebElement cart = waitForElementLocatedBy(driver, By.xpath("//*[@id='nav-cart']/a"));
        cart.click();

        String expectedName = "Nike React Infinity Run Flyknit Premium";
        String expectedTitle = "Женская беговая обувь";
        String expectedColor = "Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey";
        String expectedSize = "9 (RU 39,5)";
        String expectedPrice = "12 999,00 ₽";
        String expectedCount = "1";

        WebElement actualName = driver.findElement(By.xpath("//*[contains(@class, 'e5pihrt0')]"));
        WebElement actualTitle = driver.findElement(By.xpath("//*[contains(@class, 'css-ommkxx')]"));
        WebElement actualColor = driver.findElement(By.xpath("//*[contains(@class, 'css-ydoq90')]"));
        WebElement actualSize = driver.findElement(By.xpath("//*[@value='70a3beda-fc15-59f0-95e9-82d145240dd1']"));
        WebElement actualPrice = driver.findElement(By.xpath("//*[contains(@class, 'ew71yvl1')]"));
        WebElement actualCount = driver.findElement(By.xpath("//*[@value='1']"));

        Assert.assertEquals(expectedName, actualName.getText());
        Assert.assertEquals(expectedTitle, actualTitle.getText());
        Assert.assertEquals(expectedColor, actualColor.getText());
        Assert.assertEquals(expectedSize, actualSize.getText());
        Assert.assertEquals(expectedPrice, actualPrice.getText());
        Assert.assertEquals(expectedCount, actualCount.getText());

        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
