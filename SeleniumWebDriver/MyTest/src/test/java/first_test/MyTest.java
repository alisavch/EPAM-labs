package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");

        WebElement closeLocation = waitForElementLocatedBy(driver, By.xpath("//i[@class='g72-x-circle fs32-nav-sm nav-color-black']"));
        closeLocation.click();
//        WebElement clickToClose = driver.findElement(By.xpath("//i[@class='g72-x-circle fs32-nav-sm']"));
//        clickToClose.click();

        List<WebElement> sizeBtn = driver.findElements(By.xpath("//label[@class='css-xf3ahq']"));
        sizeBtn.get(8).click();
        WebElement addToBag = driver.findElement(By.xpath("//*[@id='floating-atc-wrapper']/div/button[1]"));
        addToBag.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//*[@id='nav-cart']/a")));
        WebElement cart = waitForElementLocatedBy(driver, By.xpath("//*[@id='nav-cart']/a"));
        cart.click();
        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
