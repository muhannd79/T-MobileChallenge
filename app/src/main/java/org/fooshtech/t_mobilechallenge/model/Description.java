package org.fooshtech.t_mobilechallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Description implements Serializable {

    @SerializedName("value")
    @Expose
    private String value;

    @SerializedName("attributes")
    @Expose
    private Attributes attributes;

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
}
