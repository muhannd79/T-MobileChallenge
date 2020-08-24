package org.fooshtech.t_mobilechallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Attributes implements Serializable {

    @SerializedName("text_color")
    @Expose
    private String textColor;
    @SerializedName("font")
    @Expose
    private CardFont font;

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public CardFont getFont() {
        return font;
    }

    public void setFont(CardFont font) {
        this.font = font;
    }


}
