package com.myamazingproject.model;

public enum Colour {
    black("Черный"),
    blue("Синий"),
    green("Зеленый"),
    gray("Серый"),
    multicolor("Мультиколор"),
    orange("Оранжевый"),
    pink("Розовый"),
    purpe("Пурпурный"),
    red("Красный"),
    white("Белый");

    private final String colour;

    Colour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
}
