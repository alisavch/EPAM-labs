import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

import java.util.List;

public class BringItOn {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebElement enterText = driver.findElement(By.id("postform-text"));
        enterText.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
        WebElement clickSyntax = driver.findElement(By.xpath("//span[@title='Bash']"));
        clickSyntax.click();
        List<WebElement> enterSyntax = driver.findElements(By.xpath("//li[text()='Bash']"));
        enterSyntax.get(0).click();
        WebElement clickExpration = driver.findElement(By.id("select2-postform-expiration-container"));
        clickExpration.click();
        List<WebElement> enterExpration = driver.findElements(By.xpath("//li[text()='10 Minutes']"));
        enterExpration.get(0).click();
        WebElement enterName = driver.findElement(By.id("postform-name"));
        enterName.sendKeys("how to gain dominance among developers");
        WebElement createBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        createBtn.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
