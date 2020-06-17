package com.example.covidata.ui.countries;

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
import com.android.volley.toolbox.JsonArrayRequest;
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

public class CountriesFragment extends Fragment {

    private CountriesViewModel galleryViewModel;

    RecyclerView recyclerView;

    private RequestQueue mQueue;
    private StringRequest request;

    String url = "https://coronavirus-19-api.herokuapp.com/countries";
    countriesAdapter adp;
    List<pojoCountries> ar1;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(CountriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_countries, container, false);



        recyclerView=root.findViewById(R.id.recycler);
        ar1=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mQueue = Volley.newRequestQueue(getContext());


        request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray jsona = new JSONArray(response);

                    for(int i=1;i<jsona.length();i++)
                    {
                        JSONObject jsonObject=    jsona.getJSONObject(i);
                        pojoCountries pj=new pojoCountries(jsonObject.getString("country"),jsonObject.getString("cases"),jsonObject.getString("todayCases"));
                        ar1.add(pj);
                    }

                    adp=new countriesAdapter(getContext(),ar1);
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