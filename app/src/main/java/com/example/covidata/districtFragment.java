package com.example.covidata;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covidata.adapter.districtAdapter;
import com.example.covidata.adapter.indiaStateAdapter;
import com.example.covidata.pojo.pojoDistrict;
import com.example.covidata.pojo.pojoIndiaStates;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class districtFragment extends Fragment {

String stname;
    private RequestQueue mQueue;
    private StringRequest request;

    RecyclerView recyclerView;
    List<pojoDistrict> ar1;
    districtAdapter adp;
    String url = "https://api.covid19india.org/v2/state_district_wise.json";

    public districtFragment() {
        // Required empty public constructor
    }
    public districtFragment(String stname) {
        // Required empty public constructor
        this.stname=stname;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_district, container, false);
        recyclerView=root.findViewById(R.id.recycler);
        ar1=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mQueue = Volley.newRequestQueue(getContext());


        request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

               JSONArray jsonArray=new JSONArray(response);



                    for(int i=1;i<jsonArray.length();i++)
                    {
                    if (jsonArray.getJSONObject(i).getString("state").equals(stname))

                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                       JSONArray jsa= jsonObject.getJSONArray("districtData");

                       for (int n=0;n<jsa.length();n++)
                       {
                           JSONObject jsb1=jsa.getJSONObject(n);
                           pojoDistrict pj=new pojoDistrict(jsb1.getString("district"), jsb1.getString("confirmed"),jsb1.getString("deceased"));
                           ar1.add(pj);
                       }

                    }


                    }

                    adp=new districtAdapter(getContext(),ar1);
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





        return  root;
    }

}
