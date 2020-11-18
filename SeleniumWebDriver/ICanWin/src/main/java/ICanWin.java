import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

import java.util.List;

public class ICanWin {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebElement enterText = driver.findElement(By.id("postform-text"));
        enterText.sendKeys("Hello from WebDriver");
        WebElement clickExpration = driver.findElement(By.id("select2-postform-expiration-container"));
        clickExpration.click();
        List<WebElement> enterExpration = driver.findElements(By.xpath("//li[text()='10 Minutes']"));
        enterExpration.get(0).click();
        WebElement enterName = driver.findElement(By.id("postform-name"));
        enterName.sendKeys("helloweb");
        WebElement createBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        createBtn.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
