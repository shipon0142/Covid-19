
package com.example.covid_19.Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Series {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("data")
    @Expose
    private List<Object> data = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

}
