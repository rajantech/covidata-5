package com.example.covidata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ruf extends AppCompatActivity {

    StringRequest stringRequest;

    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruf);


        requestQueue = Volley.newRequestQueue(this);




    }
}
