package com.myamazingproject.page;

import com.myamazingproject.model.CardInfo;
import com.myamazingproject.model.UserInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends Page{

    @FindBy (xpath = "//*[@name='lastname'][@id='Shipping_LastName']")
    private WebElement lastnameLocator;

    @FindBy (xpath = "//*[@name='firstname'][@id='Shipping_FirstName'] ")
    private WebElement fisrtNameLocator;

    @FindBy (xpath = "//*[@name='middlename'][@id='Shipping_MiddleName'] ")
    private WebElement patronymicLocator;

    @FindBy (xpath = "//*[@name='pcode'][@id='Shipping_PostCode'] ")
    private WebElement postCodeLocator;

    @FindBy (xpath = "//*[@name='shippingCity'][@id='Shipping_City'] ")
    private  WebElement cityLocator;

    @FindBy (xpath = "//*[@name='shippingAddress1'][@id='Shipping_Address1'] ")
    private WebElement addressLocator;

    @FindBy (xpath = "//*[@name='shippingPhoneNumber'][@id='Shipping_phonenumber'] ")
    private WebElement phoneNumberLocator;

    @FindBy (xpath = "//*[@name='shippingEmail'][@id='shipping_Email'] ")
    private WebElement emailLocator;

    @FindBy (xpath = "//*[@name='cardName'][@id='cardName-input'] ")
    private WebElement cardNameLocator;

    @FindBy (xpath = "//*[@name='cardNumber'][@id='cardNumber-input'] ")
    private WebElement cardNumberLocator;

    @FindBy (xpath = "//*[@name='cardExpiry'][@id='cardExpiry-input'] ")
    private WebElement cardMmyyLocator;

    @FindBy (xpath = "//*[@name='cardCvc'][@id='cardCvc-input'] ")
    private WebElement cardCvvLocator;

    @FindBy (xpath = "//*[@id='ch4_summaryTotal']//*[@class='ng-binding']")
    private WebElement totalPriceLocator;

    @FindBy (xpath = "//*[@class='checkbox-checkmark']")
    private WebElement agreementLocator;

    @FindBy (xpath = "//*[@class='order-buttons-area']//*[@name='shipSubmit'][contains(@class,'hidden-xs')]")
    private WebElement shippingSubmitLocator;

    @FindBy (xpath = "//*[@class='order-buttons-area']//*[contains(@class,'hidden-xs')][@name='billingSubmit']")
    private WebElement proceedToCheckoutLocator;

    @FindBy (xpath = "//*[@id='new-card-paynow']")
    private WebElement cardPaynowLocator;

    @FindBy (xpath = "//*[text()='Payment']")
    private WebElement popUpPaymentLocator;

    public OrderPage(WebDriver driver, String pageURL) {
        super(driver, pageURL);
    }

    public OrderPage enterTheUserData(UserInfo user) {
        waitForElementLocatedBy(driver, fisrtNameLocator).sendKeys(user.getFirstName());
        waitForElementLocatedBy(driver, lastnameLocator).sendKeys(user.getLastName());
        waitForElementLocatedBy(driver, patronymicLocator).sendKeys(user.getPatronymic());
        waitForElementLocatedBy(driver, postCodeLocator).sendKeys(user.getPostcode());
        waitForElementLocatedBy(driver, cityLocator).sendKeys(user.getCity());
        waitForElementLocatedBy(driver, addressLocator).sendKeys(user.getAddress());
        waitForElementLocatedBy(driver, phoneNumberLocator).sendKeys(user.getPhoneNumber());
        waitForElementLocatedBy(driver, emailLocator).sendKeys(user.getEmail());
        return this;
    }

    public OrderPage enterTheCardData(CardInfo card) {
        waitForElementLocatedBy(driver, cardNameLocator).sendKeys(card.getCardName());
        waitForElementLocatedBy(driver, cardNumberLocator).sendKeys(card.getCardNumber());
        waitForElementLocatedBy(driver, cardMmyyLocator).sendKeys(card.getMmyy());
        waitForElementLocatedBy(driver, cardCvvLocator).sendKeys(card.getCvv());
        return this;
    }

    public String totalPrice() {
        return waitForElementLocatedBy(driver,totalPriceLocator).getText().replaceAll("₽", "").trim();
    }

    public OrderPage agreement() {
        fluentWaitForElementLocatedBy(driver, agreementLocator).click();
        return this;
    }

    public OrderPage shippingSubmit() {
        fluentWaitForElementLocatedBy(driver, shippingSubmitLocator).click();
        return this;
    }

    public OrderPage proceedToCheckout() {
        fluentWaitForElementLocatedBy(driver, proceedToCheckoutLocator).click();
        return this;
    }

    public OrderPage paynow() {
        fluentWaitForElementLocatedBy(driver, cardPaynowLocator).click();
        return this;
    }

    public String popUpPayment() {
        return waitForElementLocatedBy(driver, popUpPaymentLocator).getText().trim();
    }
}
