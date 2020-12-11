package com.example.covidata.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    TextView confirmed, deceased, infected, recovered,todayNewCases,todaydeath;
    PieChartView pieChartView;
    StringRequest stringRequest;
    RequestQueue requestQueue;
    List pieData = new ArrayList<>();
    String url="https://api.covid19api.com/summary";

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
            todayNewCases = root.findViewById(R.id.todayNewCases);
            todaydeath = root.findViewById(R.id.todayDeath);
            pieChartView = root.findViewById(R.id.chart);




                requestQueue = Volley.newRequestQueue(getContext());


                stringRequest = new StringRequest(Request.Method.GET, "https://api.covid19api.com/summary", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject jsonObject1= jsonObject.getJSONObject("Global");



                           confirmed.setText(jsonObject1.getString("TotalConfirmed"));
                            pieData.add(new SliceValue(Float.valueOf(jsonObject1.getString("TotalConfirmed")), Color.rgb(226,116,48)).setLabel("TotalConfirmed"));

                            deceased.setText(jsonObject1.getString("TotalDeaths"));
                            pieData.add(new SliceValue(Float.valueOf(jsonObject1.getString("TotalDeaths")), Color.RED).setLabel("Total Deaths"));


                           recovered.setText(jsonObject1.getString("TotalRecovered"));
                            pieData.add(new SliceValue(Float.valueOf(jsonObject1.getString("TotalRecovered")), Color.GREEN).setLabel("Total Recovered"));



                           todayNewCases.setText("+"+jsonObject1.getString("NewConfirmed"));

                            todaydeath.setText("+"+jsonObject1.getString("NewDeaths"));



                           int totalactive;

                           totalactive=(Integer.parseInt(jsonObject1.getString("TotalConfirmed"))-Integer.parseInt(jsonObject1.getString("TotalRecovered")));

                                String seriouscases=String.valueOf(totalactive);
                            infected.setText(seriouscases);
                            pieData.add(new SliceValue(Float.valueOf(seriouscases), Color.BLUE).setLabel("Seroius Cases"));

                                        drawPiechart();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getContext(),"catch",Toast.LENGTH_LONG).show();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),"Volley Error",Toast.LENGTH_LONG).show();

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
