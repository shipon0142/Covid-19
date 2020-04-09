
package com.example.covid_19.Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class XAxis {

    @SerializedName("categories")
    @Expose
    private List<String> categories = null;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

}
