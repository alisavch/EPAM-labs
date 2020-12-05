package page;

import model.ProductInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CartPage extends  Page {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public List<ProductInfo> getInCartProductInfo() {
        By productsInfoLocator = By.xpath("//*[@class='css-1930mmg ezer4f61']");
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        List<WebElement> productsInfo = (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productsInfoLocator));

        List<ProductInfo> productInfoList = new ArrayList<ProductInfo>();
        for(WebElement productInfo : productsInfo) {
            String name = productInfo.findElement(By.xpath("//*[contains(@class, 'e5pihrt0')]")).getText().trim();
            String title = productInfo.findElement(By.xpath("//*[contains(@class, 'css-ommkxx')]")).getText().trim();;
            String colour = productInfo.findElement(By.xpath("//*[contains(@class, 'css-ydoq90')]")).getText().trim();;
            String price = productInfo.findElement(By.xpath("//div[@class='ncss-col-sm-6']//*[contains(@class, 'ew71yvl1')]")).getText().trim();;
            String size = null;
            if(productInfo.findElements(By.xpath("//*[@class='css-w53gby e4f9riy4'][@data-automation='size-select']")).size() > 0){
                size = productInfo.findElement(By.xpath("//option[@value='70a3beda-fc15-59f0-95e9-82d145240dd1']")).getText().trim();
            }
            String count = null;
            if(productInfo.findElements(By.xpath("//*[@class='css-w53gby e4f9riy4'][@data-automation='quantity-select']")).size() > 0) {
                count = productInfo.findElement(By.xpath("//option[@value='1']")).getText().trim();
            }
            productInfoList.add(new ProductInfo(name, title, colour, size, price, count));
        }
        return productInfoList;
    }
}