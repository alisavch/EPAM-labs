package com.myamazingproject.model;

import lombok.Getter;
import lombok.Setter;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
@Setter
public class CardInfo {

    private String cardName;
    private String cardNumber;
    private String mmyy;
    private String cvv;

    public CardInfo(String cardName, String cardNumber, String mmyy, String cvv) {
        checkNotNull(cardName);
        checkNotNull(cardNumber);
        checkNotNull(mmyy);
        checkNotNull(cvv);

        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.mmyy = mmyy;
        this.cvv = cvv;
    }

    public static CardInfo of(String cardName, String cardNumber, String mmyy, String cvv) {
        return new CardInfo(cardName, cardNumber, mmyy, cvv);
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getMmyy() {
        return mmyy;
    }

    public String getCvv() {
        return cvv;
    }
}
