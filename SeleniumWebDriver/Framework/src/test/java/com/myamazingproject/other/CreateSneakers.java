package com.myamazingproject.other;

import com.myamazingproject.model.SneakersInfo;

public class CreateSneakers {

    private static final String SNEAKERS_NAME = "test.data.%s.name";
    private static final String SNEAKERS_TITLE = "test.data.%s.title";
    private static final String SNEAKERS_COLOUR = "test.data.%s.colour";
    private static final String SNEAKERS_SIZE = "test.data.%s.size";
    private static final String SNEAKERS_PRICE = "test.data.%s.price";
    private static final String SNEAKERS_COUNT = "test.data.%s.count";

    public static SneakersInfo getSneakers(String data) {
        data = data.toLowerCase();

        String sneakersName = getTemplate(SNEAKERS_NAME, data);
        String sneakersTitle = getTemplate(SNEAKERS_TITLE, data);
        String sneakersColour = getTemplate(SNEAKERS_COLOUR, data);
        String sneakersSize = getTemplate(SNEAKERS_SIZE, data);
        String sneakersPrice = getTemplate(SNEAKERS_PRICE, data);
        String sneakersCount = getTemplate(SNEAKERS_COUNT, data);

        return SneakersInfo.of(TestDataReader.getTestData(sneakersName),
                TestDataReader.getTestData(sneakersTitle),
                TestDataReader.getTestData(sneakersColour),
                TestDataReader.getTestData(sneakersSize),
                TestDataReader.getTestData(sneakersPrice),
                TestDataReader.getTestData(sneakersCount));
    }

    public static String getTemplate(String template, String data) {
        return String.format(template, data);
    }
}
