package com.myamazingproject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SearchClothesPage extends Page{

    @FindBy (xpath = "//*[@class='_1uZt26F-']//*[text()='Одежда']")
    private WebElement clothesWomenLocator;

    @FindBy (xpath = "//*[@class='categories css-1m2o0em is--desktop']//*[text()='Шорты']")
    private WebElement shortsLocator;

    @FindBy (xpath = "//*[@class='product-card__body']//*[@class='product-card__subtitle']")
    private WebElement titleShortsLocator;

    public SearchClothesPage(WebDriver driver, String pageURL) {
        super(driver, pageURL);
    }

    public SearchClothesPage selectClothes() {
        clothesWomenLocator.click();
        return this;
    }

    public SearchClothesPage selectShorts() {
        shortsLocator.click();
        return this;
    }

    public boolean checkThingInTitle(String thing) {
        String titlesArray = titleShortsLocator.getText().trim();
        return checkForContainsShorts(titlesArray, thing);
    }

    public boolean checkForContainsShorts(String array, String thing) {
        String[] foundedShorts = new String[0];
            for(int i=0; i< array.length(); i++) {
                Arrays.stream(foundedShorts).collect(Collectors.toList()).add(0,array);
            }
        String[] boolTempArray = new String[0];
        Arrays.stream(foundedShorts).forEach(text -> text.split(" "));
        Arrays.stream(foundedShorts).collect(Collectors.toList()).stream().filter(word -> word.equals(thing.toLowerCase()));
        return foundedShorts.length == boolTempArray.length;
    }

}
