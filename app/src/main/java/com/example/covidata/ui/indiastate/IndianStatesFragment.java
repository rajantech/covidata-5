package com.example.covidata.ui.indiastate;

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
import com.example.covidata.adapter.countriesAdapter;
import com.example.covidata.adapter.*;
import com.example.covidata.pojo.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class IndianStatesFragment extends Fragment {

    RecyclerView recyclerView;
    List<pojoIndiaStates> ar1;
    indiaStateAdapter adp;

    private RequestQueue mQueue;
    private StringRequest request;

    String url = "https://api.covidindiatracker.com/state_data.json";

    private IndianStatesViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(IndianStatesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_indianstates, container, false);


        recyclerView=root.findViewById(R.id.recycler);
        ar1=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mQueue = Volley.newRequestQueue(getContext());




        request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray jsona = new JSONArray(response);

                    for(int i=0;i<jsona.length();i++)
                    {
                        JSONObject jsonObject=    jsona.getJSONObject(i);
                        pojoIndiaStates pj=new pojoIndiaStates(jsonObject.getString("state"),jsonObject.getString("confirmed"),jsonObject.getString("cChanges"));
                        ar1.add(pj);
                    }

                    adp=new indiaStateAdapter(getContext(),ar1);
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