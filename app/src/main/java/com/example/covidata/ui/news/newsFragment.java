package com.example.covidata.ui.news;



import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covidata.R;
import com.example.covidata.*;
import com.example.covidata.adapter.countriesAdapter;
import com.example.covidata.adapter.newsAdapter;
import com.example.covidata.pojo.pojoCountries;
import com.example.covidata.pojo.pojoNews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class newsFragment extends Fragment {
    RecyclerView recyclerView;

    private RequestQueue mQueue;
    private StringRequest request;



    String url = "http://newsapi.org/v2/everything?language=en&q=coronavirus&from=2020-06-09&sortBy=popularity&apiKey=f8513c13f26b4d81b6d7f6128291b8a2";
    newsAdapter adp;
    List<pojoNews> ar1;


    public newsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view  =  inflater.inflate(R.layout.fragment_news, container, false);


        recyclerView=view.findViewById(R.id.recycler);
        ar1=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        String date = sdf.format(c.getTime());

        mQueue = Volley.newRequestQueue(getContext());





        request = new StringRequest(Request.Method.GET,"http://newsapi.org/v2/everything?language=en&q=coronavirus&from="+date+"&sortBy=popularity&apiKey=f8513c13f26b4d81b6d7f6128291b8a2", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsona = new JSONObject(response);

                 JSONArray jsonArray =   jsona.getJSONArray("articles");


                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject=    jsonArray.getJSONObject(i);
                        pojoNews pj=new pojoNews(jsonObject.getString("urlToImage"),jsonObject.getString("author"),jsonObject.getString("url"),jsonObject.getString("title"),jsonObject.getString("publishedAt"));
                        ar1.add(pj);
                    }

                    adp=new newsAdapter(getContext(),ar1);
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










        return view;
    }

}
