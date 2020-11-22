//package pageobject_model.test;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class WebDriverSeleniumHQTest {
//    private WebDriver driver;
//
//    @BeforeMethod(alwaysRun = true)
//    public void browserSetup(){
//        driver = new ChromeDriver();
//    }
//
//    @Test (description = "Just ferst test")
//    public void addSneakersToCartTest() {
//        int expectedSearchResultNumber = new SeleniumHQHomePage()
//                .openPage()
//                .searchForTerms("selenium java")
//                .countSearchResults();
//
//        Assert.assertEquals(expectedName, actualName.getText());
//        Assert.assertEquals(expectedTitle, actualTitle.getText());
//        Assert.assertEquals(expectedColor, actualColor.getText());
//        Assert.assertEquals(expectedSize, actualSize.getText());
//        Assert.assertEquals(expectedPrice, actualPrice.getText());
//        Assert.assertEquals(expectedCount, actualCount.getText());
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void browserTearDown(){
//        driver.quit();
//        driver=null;
//    }
//
//    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
//        return new WebDriverWait(driver, 15)
//                .until(ExpectedConditions.presenceOfElementLocated(by));
//    }
//}
