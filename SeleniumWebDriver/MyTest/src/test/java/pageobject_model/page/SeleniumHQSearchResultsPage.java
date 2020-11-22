//package pageobject_model.page;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//
//public class SeleniumHQSearchResultsPage extends AbstractPage{
//    String expectedName = "Nike React Infinity Run Flyknit Premium";
//    String expectedTitle = "Женская беговая обувь";
//    String expectedColor = "Фиолетовый пепел/Розовый взрыв/Ярко-розовый/Dark Smoke Grey";
//    String expectedSize = "9 (RU 39,5)";
//    String expectedPrice = "12 999,00 ₽";
//    String expectedCount = "1";
//
//    WebElement actualName = driver.findElement(By.xpath("//*[contains(@class, 'e5pihrt0')]"));
//    WebElement actualTitle = driver.findElement(By.xpath("//*[contains(@class, 'css-ommkxx')]"));
//    WebElement actualColor = driver.findElement(By.xpath("//*[contains(@class, 'css-ydoq90')]"));
//    WebElement actualSize = driver.findElement(By.xpath("//*[@value='70a3beda-fc15-59f0-95e9-82d145240dd1']"));
//    WebElement actualPrice = driver.findElement(By.xpath("//*[contains(@class, 'ew71yvl1')]"));
//    WebElement actualCount = driver.findElement(By.xpath("//*[@value='1']"));
//
//    @Override
//    protected AbstractPage openPage(){
//        throw new RuntimeException("Please 'think twice' whether you need " +
//                "if direct access is still needed - please dig into Google"+
//                "oa avoid inheritance from AbstractPage"+
//                "or remove openPage() method from AbstractPage");
//    }
//}
