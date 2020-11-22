//package pageobject_model.page;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.List;
//
//public class HQSeleniumHomePage extends AbstractPage {
////    private static final String HOMEPAGE_URL = "https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500";
//
//    driver.get("https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");
//    driver.manage().window().maximize();
////        driver.manage().addCookie(new Cookie("key", "value"));
//
//    @FindBy(xpath="//i[@class='g72-x-circle fs32-nav-sm nav-color-black']")
//    private WebElement closeLocation;
////    WebElement closeLocation = waitForElementLocatedBy(driver, By.xpath("//i[@class='g72-x-circle fs32-nav-sm nav-color-black']"));
////        closeLocation.click();
////        WebElement clickToClose = driver.findElement(By.xpath("//i[@class='g72-x-circle fs32-nav-sm']"));
////        clickToClose.click();
//    List<WebElement> sizeBtn = driver.findElements(By.xpath("//label[@class='css-xf3ahq']"));
//        sizeBtn.get(8).click();
//    WebElement addToBag = waitForElementLocatedBy(driver, By.xpath("//button[contains(@class,'add-to-cart-btn')]"));
//        addToBag.click();
//    new WebDriverWait(driver, 10)
//                .until(ExpectedConditions
//                               .presenceOfAllElementsLocatedBy(By.xpath("//*[@id='nav-cart']/a")));
//    WebElement cart = waitForElementLocatedBy(driver, By.xpath("//*[@id='nav-cart']/a"));
//        cart.click();
//
//    public HQSeleniumHomePage openPage(){
//        driver.get(HOMEPAGE_URL);
//        new WebDriverWait(driver, WAIT_TIME_SECONDS)
//                .until(CustomConditions)
//    }
//}
