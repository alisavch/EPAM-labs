package com.myamazingproject.test;

import com.myamazingproject.model.Colour;
import com.myamazingproject.model.SneakersSize;
import com.myamazingproject.model.SneakersInfo;
import com.myamazingproject.other.CreateSneakers;
import com.myamazingproject.page.CartPage;
import com.myamazingproject.page.MainPage;
import com.myamazingproject.page.SneakersPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NikeCartTest extends CommonConditions {

    private static final String SNEAKERS_INPUT = "Nike React";
    public static MainPage mainPage;
    public static SneakersPage sneakersPage;
    public static CartPage cartPage;

    @Test (priority = 2)
    public void addSneakersToCartTest() {
        SneakersInfo expectedSneakers = CreateSneakers.getSneakers("first");
        mainPage = new MainPage(driver, "https://www.nike.com/");
        mainPage.openPage();
        mainPage.popUpWindow().selectCountry();
        sneakersPage = mainPage
                .inputValueToSearch(SNEAKERS_INPUT)
                .search()
                .filterColour(Colour.purpe)
                .selectSneakers();
        cartPage = sneakersPage.chooseSize(SneakersSize.US9)
                .addToCart()
                .shoppingCart();
        List<SneakersInfo> productInfoList = cartPage.getInCartProductInfo();
        assertThat(productInfoList.get(0), is(expectedSneakers));
    }

    @Test (priority = 3)
    public void emptyCartTest() {
        SneakersInfo expectedSneakers = CreateSneakers.getSneakers("first");
        SneakersPage sneakersPage = new SneakersPage(driver, "https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");
        sneakersPage.openPage();
        CartPage cartPage = sneakersPage.chooseSize(SneakersSize.US9)
                .addToCart()
                .shoppingCart();
        List<SneakersInfo> productInfoList = cartPage.getInCartProductInfo();
        assertThat(productInfoList.get(0).name, is(expectedSneakers.name));
        cartPage.removeFromCart();
        assertThat(cartPage.emptyCart(), is("В корзине пока нет товаров."));
    }

    @Test (priority = 4)
    public void priceCalculationTest() {
        SneakersPage sneakersPage = new SneakersPage(driver, "https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");
        sneakersPage.openPage();
        CartPage cartPage = sneakersPage.chooseSize(SneakersSize.US9)
                .addToCart()
                .shoppingCart();
        List<SneakersInfo> productInfoList = cartPage.getInCartProductInfo();
        assertThat(productInfoList.get(0).price, is("10 480,00"));
        SneakersPage sneakersPage2 = new SneakersPage(driver, "https://www.nike.com/ru/t/%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-%D0%B4%D0%BB%D1%8F-%D0%B7%D0%B0%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2-air-zoom-alphafly-next-g2tqPZ/CZ1514-800");
        sneakersPage2.openPage();
        sneakersPage2.chooseSize(SneakersSize.US9)
                .addToCart()
                .shoppingCart();
        assertThat(cartPage.getPrice(),is("33 779,00"));
    }

    @Test (priority = 8)
    public void addToFavoriteNotSignedAccountTest() {
        SneakersPage sneakersPage = new SneakersPage(driver, "https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");
        sneakersPage.openPage();
        CartPage cartPage = sneakersPage.chooseSize(SneakersSize.US9)
                .addToCart()
                .shoppingCart()
                .addToFavourite();
        assertThat(cartPage.popUpSignIn(), is("ЕДИНЫЙ АККАУНТ ДЛЯ ЛЮБОЙ СРЕДЫ NIKE"));
    }
}
