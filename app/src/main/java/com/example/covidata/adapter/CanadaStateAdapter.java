package com.example.covidata.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.covidata.R;
import com.example.covidata.*;
import com.example.covidata.pojo.*;

import java.util.List;

public class CanadaStateAdapter extends RecyclerView.Adapter<CanadaStateAdapter.ViewHolder> {
    List<pojoCanadaStates>  listdata;
    Context context;

    // RecyclerView recyclerView;
    public CanadaStateAdapter(Context context, List<pojoCanadaStates> listdata) {

        this.listdata = listdata;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.canada_data_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final pojoCanadaStates myListData = listdata.get(position);

        holder.textView.setText(myListData.getStateName());
        holder.cases.setText(String.valueOf(myListData.getStateTotalCases()));
        holder.totaldeaths.setText("deaths: "+myListData.getStateTotalDeaths());



    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView cases;
        public  TextView totaldeaths;
        public LinearLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.cases = (TextView) itemView.findViewById(R.id.textView2);
            this.totaldeaths = (TextView) itemView.findViewById(R.id.newCases);

            relativeLayout = (LinearLayout) itemView.findViewById(R.id.relativeLayout);
        }
    }
}