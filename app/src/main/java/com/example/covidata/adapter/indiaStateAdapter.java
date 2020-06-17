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

public class indiaStateAdapter extends RecyclerView.Adapter<indiaStateAdapter.ViewHolder> {
    List<pojoIndiaStates>  listdata;
    Context context;

    // RecyclerView recyclerView;
    public indiaStateAdapter(Context context, List<pojoIndiaStates> listdata) {

        this.listdata = listdata;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.india_data_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
       final pojoIndiaStates myListData = listdata.get(position);


       holder.textView.setText(myListData.getStateName());
       String nm=myListData.getStateName();
       holder.cases.setText(myListData.getStateTotalCases());
       holder.newCases.setText("+"+myListData.getStateTodayCases());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,state_data.class);
                intent.putExtra("stateName",holder.textView.getText().toString());
                context.startActivity(intent);

            }
        });


    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView cases;
        public  TextView newCases;
        public LinearLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.cases = (TextView) itemView.findViewById(R.id.textView2);
            this.newCases = (TextView) itemView.findViewById(R.id.newCases);
            relativeLayout=itemView.findViewById(R.id.relativeLayout);

        }
    }
}