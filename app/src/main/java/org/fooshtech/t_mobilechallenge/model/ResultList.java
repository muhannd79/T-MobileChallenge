package org.fooshtech.t_mobilechallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResultList implements Serializable {

    @SerializedName("page")
    @Expose
    private Pages page;

    public Pages getPage() {
        return page;
    }

    public void setPage(Pages page) {
        this.page = page;
    }
}
