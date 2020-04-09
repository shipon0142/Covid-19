
package com.example.covid_19.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YAxis {

    @SerializedName("title")
    @Expose
    private Title_ title;

    public Title_ getTitle() {
        return title;
    }

    public void setTitle(Title_ title) {
        this.title = title;
    }

}
