package com.example.covidata;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covidata.adapter.CanadaStateAdapter;
import com.example.covidata.pojo.pojoCanadaStates;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Intent.getIntent;


/**
 * A simple {@link Fragment} subclass.
 */
public class stateFragment extends Fragment {

    TextView totalconfirmed,totalactive,totaldeaths,totalrecovered,statenm;
    private RequestQueue mQueue;
    private StringRequest request;
    ProgressBar progressBar;
    LinearLayout linearLayout;
    String state;


    public stateFragment() {
        // Required empty public constructor
    }

    public stateFragment(String state) {
        this.state=state;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_state, container, false);
        totalconfirmed=root.findViewById(R.id.totalConfirmed);
        totalactive=root.findViewById(R.id.totalactive);
        progressBar=root.findViewById(R.id.progressId);
        linearLayout=root.findViewById(R.id.linearId);
        totaldeaths=root.findViewById(R.id.totaldeaths);
        totalrecovered=root.findViewById(R.id.totalrecovered);
        statenm=root.findViewById(R.id.statename);
linearLayout.setVisibility(View.GONE);
        mQueue = Volley.newRequestQueue(getContext());




        request = new StringRequest(Request.Method.GET, "https://api.covidindiatracker.com/state_data.json", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray jsona = new JSONArray(response);

                        for (int i=0;i<jsona.length();i++)
                        {
                            JSONObject jsonObject=jsona.getJSONObject(i);
                          if(jsonObject.getString("state").equalsIgnoreCase(state))
                          {
                              totalconfirmed.setText(jsonObject.getString("confirmed"));
                              totalactive.setText(jsonObject.getString("active"));
                              totalrecovered.setText(jsonObject.getString("recovered"));
                              statenm.setText(jsonObject.getString("state"));
                              totaldeaths.setText(jsonObject.getString("deaths"));
                              progressBar.setVisibility(View.GONE);
                              linearLayout.setVisibility(View.VISIBLE);
                          }

                        }



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
