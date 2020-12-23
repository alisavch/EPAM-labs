package com.myamazingproject.test;

import com.myamazingproject.page.MainPage;
import com.myamazingproject.page.SearchClothesPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NikeShortsTest extends CommonConditions{

    public static MainPage mainPage;

    @Test(priority = 1)
    public void filterClothesTest() {
        mainPage = new MainPage(driver, "https://www.nike.com/");
        mainPage.openPage();
        mainPage.popUpWindow().selectCountry();
        SearchClothesPage search = mainPage
                .selectWomen()
                .selectClothes()
                .selectShorts();
        boolean res = search.checkThingInTitle("Шорты");
        assertThat(res, is(true));
    }
}
