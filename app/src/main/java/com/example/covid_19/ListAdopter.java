package com.example.covid_19;

import android.content.Context;
import android.net.ParseException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.covid_19.Pojo.DataJson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdopter extends RecyclerView.Adapter<ListAdopter.ViewHolder> {
    private Context context;
    private DataJson dataJson;


    public ListAdopter(Context context, DataJson dataJson) {
        this.context = context;
        this.dataJson=dataJson;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        String date="",affected="0";
        try {
            date=dataJson.getXAxis().getCategories().get(i).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewHolder.dateTV.setText(date);
        try {
            affected=dataJson.getSeries().get(0).getData().get(i).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(affected.contains("."))affected=affected.substring(0,affected.indexOf("."));
        viewHolder.affectedTV.setText(affected);

    }

    @Override
    public int getItemCount() {
        return dataJson.getXAxis().getCategories().size();
    }




    public interface DeleteProductCallback {
        void getDeleteProductId(String productId);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView affectedTV;
       TextView dateTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTV=itemView.findViewById(R.id.DateTV);
            affectedTV=itemView.findViewById(R.id.AffectedTV);

        }
    }

}