package com.example.covidata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covidata.adapter.countriesAdapter;
import com.example.covidata.pojo.pojoCountries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;

public class CountryData extends AppCompatActivity {
    TextView countryName,totalConfirmedcases,todayCases,totalDeaths,todayDeaths,totalRecovered,totalActive,totalCritical,
    totalCasesPerOneMillion,totalDeathsPerOneMillion,totalTests,totaltestsPerMillion;
LinearLayout linearLayout;
    private RequestQueue mQueue;
    private StringRequest request;
    String country;
    ImageView backButton;
    PieChartView pieChartView;



    List pieData = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_data);

pieChartView=findViewById(R.id.chart);
        country = getIntent().getExtras().getString("cname");
        countryName=findViewById(R.id.countryname);
        totalConfirmedcases=findViewById(R.id.totalCases);
        linearLayout=findViewById(R.id.lid);
        todayCases=findViewById(R.id.newCases);
        backButton=findViewById(R.id.back);
        totalDeaths=findViewById(R.id.totalDeaths);
        todayDeaths=findViewById(R.id.newdeaths);
        totalRecovered=findViewById(R.id.totalRecovered);
        totalActive=findViewById(R.id.activecases);
        totalCritical=findViewById(R.id.totalCritical);
        totalCasesPerOneMillion=findViewById(R.id.casesperonemillion);
        totalDeathsPerOneMillion=findViewById(R.id.deathsperonemillion);
        totalTests=findViewById(R.id.totaltests);
        totaltestsPerMillion=findViewById(R.id.totaltestsperonemillion);
      backButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              finish();
          }
      });

        mQueue = Volley.newRequestQueue(getApplicationContext());


        request = new StringRequest(Request.Method.GET, "https://coronavirus-19-api.herokuapp.com/countries/"+country, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                  JSONObject jsonObject=new JSONObject(response);
                  countryName.setText(jsonObject.getString("country"));
                    if(!jsonObject.getString("cases").equalsIgnoreCase("null")) {
                        totalConfirmedcases.setText(jsonObject.getString("cases"));
                        pieData.add(new SliceValue(Float.valueOf(jsonObject.getString("cases")), Color.rgb(226, 116, 48)).setLabel("Total Cases"));

                    }
                    else
                    { totalConfirmedcases.setText("Un Available");
                        pieData.add(new SliceValue(Float.valueOf(0), Color.rgb(226, 116, 48)).setLabel("Total Cases"));
                    }





                    if(!jsonObject.getString("todayCases").equalsIgnoreCase("null")) {
                        todayCases.setText(jsonObject.getString("todayCases"));

                    }
                    else
                    {
                        todayCases.setText("Un Available");
                    }


                    if(!jsonObject.getString("deaths").equalsIgnoreCase("null")) {
                        totalDeaths.setText(jsonObject.getString("deaths"));
                        pieData.add(new SliceValue(Float.valueOf(jsonObject.getString("deaths")), Color.RED).setLabel("Total Deaths"));
                    }
                    else
                    {
                        totalDeaths.setText("Un Available");
                        pieData.add(new SliceValue(Float.valueOf(0), Color.RED).setLabel("Total Deaths"));

                    }



                    if(!jsonObject.getString("todayDeaths").equalsIgnoreCase("null")) {
                        todayDeaths.setText(jsonObject.getString("todayDeaths"));
                    }
                    else
                    {
                        todayDeaths.setText("Un Available");
                    }



                    if(!jsonObject.getString("recovered").equalsIgnoreCase("null")) {
                        totalRecovered.setText(jsonObject.getString("recovered"));
                        pieData.add(new SliceValue(Float.valueOf(jsonObject.getString("recovered")), Color.GREEN).setLabel("Total Recovered"));

                    }
                    else
                    {
                        totalRecovered.setText("Un Available");
                        pieData.add(new SliceValue(Float.valueOf(0), Color.GREEN).setLabel("Total Recovered"));
                    }

                    if(!jsonObject.getString("active").equalsIgnoreCase("null")) {
                        totalActive.setText(jsonObject.getString("active"));
                        pieData.add(new SliceValue(Float.valueOf(jsonObject.getString("active")), Color.BLUE).setLabel("Total Active Cases"));
                    }
                    else{
                        totalActive.setText("Un Available");
                        pieData.add(new SliceValue(Float.valueOf(0), Color.BLUE).setLabel("Total Active Cases"));

                    }



                    if(!jsonObject.getString("critical").equalsIgnoreCase("null")) {
                        totalCritical.setText(jsonObject.getString("critical"));
                        pieData.add(new SliceValue(Float.valueOf(jsonObject.getString("critical")), Color.BLUE).setLabel("Seroius Cases"));

                    }
                    else
                    {
                        totalCritical.setText("Un Available");
                        pieData.add(new SliceValue(Float.valueOf(0), Color.BLUE).setLabel("Seroius Cases"));

                    }


                    if(!jsonObject.getString("casesPerOneMillion").equalsIgnoreCase("null")) {
                        totalCasesPerOneMillion.setText(jsonObject.getString("casesPerOneMillion"));
                    }
                    else
                    {
                        totalCasesPerOneMillion.setText("Un Available");
                    }


                    if(!jsonObject.getString("deathsPerOneMillion").equalsIgnoreCase("null")) {
                        totalDeathsPerOneMillion.setText(jsonObject.getString("deathsPerOneMillion"));
                    }
                    else
                    {
                        totalDeathsPerOneMillion.setText("Un Available");
                    }


                    if(!jsonObject.getString("totalTests").equalsIgnoreCase("null")) {
                        totalTests.setText(jsonObject.getString("totalTests"));
                    }
                    else
                    {
                        totalTests.setText("Un Available");
                    }


                    if(!jsonObject.getString("testsPerOneMillion").equalsIgnoreCase("null")) {
                        totaltestsPerMillion.setText(jsonObject.getString("testsPerOneMillion"));
                    }
                    else
                    {
                        totaltestsPerMillion.setText("Un Available");

                    }


                    drawPiechart();




                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Catch",Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        }){

        };

        mQueue.add(request);









    }

    public void drawPiechart(){

        // pieData.add(new SliceValue(6576666, Color.BLUE).setLabel("6576666"));
        // pieData.add(new SliceValue(756757, Color.GRAY).setLabel("756757"));
        // pieData.add(new SliceValue(76543, Color.RED).setLabel("76543"));
        // pieData.add(new SliceValue(65767, Color.MAGENTA).setLabel("65767"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(false).setValueLabelTextSize(20);
        pieChartData.setHasLabelsOutside(false);
        pieChartData.setHasCenterCircle(true).setCenterText1("Covidata").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));

        pieChartView.setPieChartData(pieChartData);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    public void backToHome(MenuItem item) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}