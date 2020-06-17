package com.example.covidata.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covidata.MainActivity;
import com.example.covidata.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class HomeFragment extends Fragment {
    private ArrayList<String> nName = new ArrayList<>();
    private ArrayList<String> mImageURLs= new ArrayList<>();
    private ArrayList<String> sub = new ArrayList<>();

    TextView confirmed, deceased, infected, recovered, tested,todayNewCases,todaydeath, totalSerius;
    PieChartView pieChartView;
    StringRequest stringRequest;
    RequestQueue requestQueue;
    List pieData = new ArrayList<>();
    String url="https://api.thevirustracker.com/free-api?global=stats";

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

            confirmed = root.findViewById(R.id.totalConfirmed);
            deceased = root.findViewById(R.id.totalDeceased);
            infected= root.findViewById(R.id.totalInfected);
            recovered= root.findViewById(R.id.totalRecovered);
            tested= root.findViewById(R.id.totalTested);
            todayNewCases = root.findViewById(R.id.todayNewCases);
            todaydeath = root.findViewById(R.id.todayDeath);
            totalSerius = root.findViewById(R.id.totalSerious);
            pieChartView = root.findViewById(R.id.chart);




                requestQueue = Volley.newRequestQueue(getContext());


                stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("results");

                            JSONObject jsonObject2 = jsonArray.getJSONObject(0);


                            confirmed.setText(jsonObject2.getString("total_cases"));
                            pieData.add(new SliceValue(Float.valueOf(jsonObject2.getString("total_cases")), Color.rgb(226,116,48)).setLabel("Total Cases"));

                            deceased.setText(jsonObject2.getString("total_deaths"));
                            pieData.add(new SliceValue(Float.valueOf(jsonObject2.getString("total_deaths")), Color.RED).setLabel("Total Deaths"));

                            infected.setText(jsonObject2.getString("total_serious_cases"));
                         //   pieData.add(new SliceValue(Float.valueOf(jsonObject2.getString("total_active_cases")), Color.DKGRAY).setLabel("Total Active Cases"));

                            recovered.setText(jsonObject2.getString("total_recovered"));
                            pieData.add(new SliceValue(Float.valueOf(jsonObject2.getString("total_recovered")), Color.GREEN).setLabel("Total Recovered"));

                            tested.setText(jsonObject2.getString("total_affected_countries"));

                            todayNewCases.setText("+"+jsonObject2.getString("total_new_cases_today"));

                            todaydeath.setText("+"+jsonObject2.getString("total_new_deaths_today"));

                            totalSerius.setText(jsonObject2.getString("total_active_cases"));
                            pieData.add(new SliceValue(Float.valueOf(jsonObject2.getString("total_serious_cases")), Color.BLUE).setLabel("Seroius Cases"));

                                        drawPiechart();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                requestQueue.add(stringRequest);


        return root;
    }



    public void drawPiechart(){

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(false).setValueLabelTextSize(20);
        pieChartData.setHasLabelsOutside(false);
        pieChartData.setHasCenterCircle(true).setCenterText1("Covidata").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));

        pieChartView.setPieChartData(pieChartData);
    }


}