package com.myamazingproject.test;

import com.myamazingproject.model.CardInfo;
import com.myamazingproject.model.SneakersSize;
import com.myamazingproject.model.SneakersInfo;
import com.myamazingproject.model.UserInfo;
import com.myamazingproject.other.CreateCard;
import com.myamazingproject.other.CreateUser;
import com.myamazingproject.page.CartPage;
import com.myamazingproject.page.OrderPage;
import com.myamazingproject.page.SneakersPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NikeOrderTest extends CommonConditions {

    @Test (priority = 9)
    public void checkingThePriceAtCheckoutTest() {
        SneakersPage sneakersPage = new SneakersPage(driver, "https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");
        sneakersPage.openPage();
        CartPage cartPage = sneakersPage.chooseSize(SneakersSize.US9)
                .addToCart()
                .shoppingCart();
        List<SneakersInfo> productInfoList = cartPage.getInCartProductInfo();
        String result = cartPage
                .checkoutWithoutRegister()
                .totalPrice();
        assertThat(productInfoList.get(0).price, is(result));
    }

    @Test (priority = 10)
    public void checkoutTest() {
        UserInfo user = CreateUser.withCredentialsFromProperty();
        CardInfo card = CreateCard.withCredentialsWithPropertyCard();
        SneakersPage sneakersPage = new SneakersPage(driver, "https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");
        sneakersPage.openPage();
        OrderPage cartPage = sneakersPage.chooseSize(SneakersSize.US9)
                .addToCart()
                .shoppingCart()
                .checkoutWithoutRegister()
                .enterTheUserData(user)
                .agreement()
                .enterTheUserData(user)
                .shippingSubmit()
                .proceedToCheckout()
                .enterTheCardData(card)
                .paynow();
        assertThat(cartPage.popUpPayment(), is("Payment"));
    }
}
