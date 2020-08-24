package org.fooshtech.t_mobilechallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cards implements Serializable {

    @SerializedName("card_type")
    @Expose
    private String cardType;


    @SerializedName("card")
    @Expose
    private CardItem card;


    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public CardItem getCard() {
        return card;
    }

    public void setCard(CardItem card) {
        this.card = card;
    }


}
