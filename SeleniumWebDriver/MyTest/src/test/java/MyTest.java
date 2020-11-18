import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");
        WebElement clickToClose = driver.findElement(By.xpath("//*[@id='gen-nav-commerce-header-v2']/aside/div/button/i"));
        clickToClose.click();
        WebElement size = driver.findElement(By.xpath("//*[@id='buyTools']/div[1]/fieldset/div/div[9]/label"));
        size.click();
        WebElement addToBag = driver.findElement(By.xpath("//button[text()='Добавить в корзину']"));
        addToBag.click();
        WebElement cart = driver.findElement(By.xpath("//*[@id='nav-cart']/a"));
        cart.click();
        Thread.sleep(5000);
        driver.quit();
    }
}
