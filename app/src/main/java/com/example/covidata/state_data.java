package com.example.covidata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import static android.content.Intent.getIntent;

public class state_data extends AppCompatActivity {

    FrameLayout fLayout;
    districtFragment dFragment;
    stateFragment sFragment;
    ImageView img1;
    String state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_data);
        setTitle("State Data");
        img1=findViewById(R.id.back);
img1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
        fLayout = findViewById(R.id.container);

   sFragment = new stateFragment();
       state = getIntent().getExtras().getString("stateName");

        dFragment = new districtFragment();
        dFragment = new districtFragment(state);
        sFragment=new stateFragment(state);

       getSupportFragmentManager().beginTransaction().add(R.id.container,sFragment).commit();


    }

    public void loadDistrict(View view) {

       dFragment=new districtFragment(state);

getSupportFragmentManager().beginTransaction().replace(R.id.container,dFragment).commit();

    }

    public void loadState(View view) {
        sFragment=new stateFragment(state);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,sFragment).commit();

    }


}
