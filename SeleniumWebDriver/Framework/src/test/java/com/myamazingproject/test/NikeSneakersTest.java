package com.myamazingproject.test;

import com.myamazingproject.model.Colour;
import com.myamazingproject.model.SneakersInfo;
import com.myamazingproject.model.SneakersSize;
import com.myamazingproject.other.CreateSneakers;
import com.myamazingproject.page.MainPage;
import com.myamazingproject.page.SneakersPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NikeSneakersTest extends CommonConditions {

    public static MainPage mainPage;
    public static SneakersPage sneakersPage;
    private static final String SNEAKERS_INPUT = "Nike React";

    @Test (priority = 1)
    public void addToCardWithoutChooseSize() {
        mainPage = new MainPage(driver, "https://www.nike.com/");
        mainPage.openPage();
        mainPage.popUpWindow().selectCountry();
        sneakersPage = mainPage
                .inputValueToSearch(SNEAKERS_INPUT)
                .search()
                .filterColour(Colour.purpe)
                .selectSneakers()
                .addToCart();
        assertThat(sneakersPage.chooseSizeNotification(), is("Выбери размер"));
    }

    @Test (priority = 5)
    public void findSneakersTest() {
        mainPage = new MainPage(driver, "https://www.nike.com/");
        mainPage.openPage();
        mainPage.popUpWindow().selectCountry();
        sneakersPage = mainPage
                .inputValueToSearch(SNEAKERS_INPUT)
                .search()
                .filterColour(Colour.purpe)
                .selectSneakers();
        SneakersInfo expectedSneakers = CreateSneakers.getSneakers("first");
        assertThat(sneakersPage.getName().trim(), is(expectedSneakers.name.trim()));
    }

    @Test (priority = 6)
    public void addToCartMoreThenTenTimesTest() {
        sneakersPage = new SneakersPage(driver, "https://www.nike.com/ru/t/%D0%B1%D0%B5%D0%B3%D0%BE%D0%B2%D1%8B%D0%B5-%D0%BA%D1%80%D0%BE%D1%81%D1%81%D0%BE%D0%B2%D0%BA%D0%B8-react-infinity-run-flyknit-premium-wr2Spw/CU0430-500");
        sneakersPage.openPage();
        sneakersPage.chooseSize(SneakersSize.US9);
        SneakersPage.getWarning(sneakersPage);
        assertThat(sneakersPage.getError(), is("Ошибка"));
    }
}
