package com.example.covidata.ui.canadaData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covidata.R;
import com.example.covidata.pojo.*;
import com.example.covidata.adapter.*;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class canadaData extends Fragment {
    RecyclerView recyclerView;
    List<pojoCanadaStates> ar1;
    CanadaStateAdapter adp;

    private RequestQueue mQueue;
    private StringRequest request;

    String url = "https://api.apify.com/v2/key-value-stores/fabbocwKrtxSDf96h/records/LATEST?disableRedirect=true";
    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_canadadata, container, false);



        recyclerView=root.findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        ar1=new ArrayList<>();

        mQueue = Volley.newRequestQueue(getContext());




        request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsona = new JSONObject(response);

                   JSONArray jsonArray= jsona.getJSONArray("infectedByRegion");

                    for(int i=0;i<jsonArray.length();i++)
                    {
                       JSONObject jsb=jsonArray.getJSONObject(i);

                        pojoCanadaStates pj=new pojoCanadaStates(jsb.getString("region"),jsb.getString("infectedCount"),jsb.getString("deceasedCount"));
                        ar1.add(pj);
                    }

                    adp=new CanadaStateAdapter(getContext(),ar1);
                    recyclerView.setAdapter(adp);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(),"Catch",Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        }){

        };

        mQueue.add(request);










        return root;
    }
}