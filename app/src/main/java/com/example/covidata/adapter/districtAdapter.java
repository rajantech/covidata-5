package com.example.covidata.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidata.R;
import com.example.covidata.pojo.pojoDistrict;
import com.example.covidata.pojo.pojoIndiaStates;

import java.util.List;

public class districtAdapter extends RecyclerView.Adapter<districtAdapter.ViewHolder>{
    Context context;
    List<pojoDistrict> ar1;

    public districtAdapter(Context context,List<pojoDistrict> ar1) {
        this.context=context;
        this.ar1=ar1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.itemsdistrict, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        pojoDistrict myListData = ar1.get(position);


        holder.districtName.setText(myListData.getDistrictname());
        holder.totalConfirmed.setText(myListData.getConfirmedcases());
        holder.totaldeceased.setText("deaths:"+myListData.getDeceased());
    }

    @Override
    public int getItemCount() {
        return ar1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView totalConfirmed,totaldeceased,districtName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            totalConfirmed=itemView.findViewById(R.id.totalcs);
            totaldeceased=itemView.findViewById(R.id.newcs);
            districtName=itemView.findViewById(R.id.districtnm);


        }
    }
}
