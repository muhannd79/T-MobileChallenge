package org.fooshtech.t_mobilechallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CardItem implements Serializable {

    @SerializedName("value")
    @Expose
    private String value;

    @SerializedName("attributes")
    @Expose
    private Attributes attributes;

    @SerializedName("title")
    @Expose
    private Title title;

    @SerializedName("description")
    @Expose
    private Description description;


    @SerializedName("image")
    @Expose
    private Image image;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
