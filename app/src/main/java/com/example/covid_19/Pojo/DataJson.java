
package com.example.covid_19.Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataJson {

    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("xAxis")
    @Expose
    private XAxis xAxis;
    @SerializedName("yAxis")
    @Expose
    private YAxis yAxis;
    @SerializedName("series")
    @Expose
    private List<Series> series = null;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public XAxis getXAxis() {
        return xAxis;
    }

    public void setXAxis(XAxis xAxis) {
        this.xAxis = xAxis;
    }

    public YAxis getYAxis() {
        return yAxis;
    }

    public void setYAxis(YAxis yAxis) {
        this.yAxis = yAxis;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }

}
