package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.covid_19.Pojo.DataJson;
import com.example.covid_19.scrapper.ScrapData;
import com.google.gson.Gson;

import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private TextView titleTV;
    private RecyclerView listRv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setExport();
    }

    private void init() {
        titleTV=findViewById(R.id.TitleTV);
        listRv=findViewById(R.id.ListRv);
    }

    private void setExport() {
        new ScrapData.SearchScrap(new ScrapData.DataCallback() {
            @Override
            public void getData(String data) {
                DataJson dataJson = new Gson().fromJson(data, DataJson.class);
                titleTV.setText(""+dataJson.getTitle().getText());
                setListAdopter(dataJson);
            }
        }).execute();
    }

    private void setListAdopter(DataJson dataJson) {
        Collections.reverse(dataJson.getXAxis().getCategories());
        Collections.reverse(dataJson.getSeries().get(0).getData());


        ListAdopter listAdopter=new ListAdopter(this,dataJson);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listRv.setLayoutManager(new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        });
        layoutManager.scrollToPositionWithOffset(0, 0);
        listRv.setItemAnimator(new DefaultItemAnimator());
        listRv.setNestedScrollingEnabled(false);
        ViewCompat.setNestedScrollingEnabled(listRv, false);
        listRv.setHasFixedSize(true);
        listRv.smoothScrollToPosition(0);
        listRv.setDrawingCacheEnabled(true);
        listRv.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        listRv.setAdapter(listAdopter);
    }

    public void CountryList(View view) {
        startActivity(new Intent(MainActivity.this,CountryActivity.class));
    }
}
