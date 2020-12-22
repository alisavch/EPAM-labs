package com.myamazingproject.other;

import com.myamazingproject.model.CardInfo;
import org.testng.annotations.Test;

public class CreateCard {
    public static final String CARD_NAME = "test.data.card.cardName";
    public static final String CARD_NUMBER = "test.data.card.cardNumber";
    public static final String CARD_MMVV = "test.data.card.mmyy";
    public static final String CARD_CVV = "test.data.card.cvv";

    public static CardInfo withCredentialsWithPropertyCard() {
        String cardName = TestDataReader.getTestData(CARD_NAME);
        String cardNumber = TestDataReader.getTestData(CARD_NUMBER);
        String cardMmvv = TestDataReader.getTestData(CARD_MMVV);
        String catdCvv = TestDataReader.getTestData(CARD_CVV);

        return CardInfo.of(cardName, cardNumber, cardMmvv, catdCvv);
    }

}
