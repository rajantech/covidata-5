package com.example.covidata;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class assesmentResult extends AppCompatActivity {
int cnt;
TextView rstl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assesment_result);
        rstl=findViewById(R.id.resu);

        cnt = getIntent().getExtras().getInt("count");
        //Toast.makeText(getApplicationContext(),String.valueOf(cnt),Toast.LENGTH_SHORT).show();

        if (cnt>=0 && cnt<=20)
        {
            rstl.setTextColor(Color.BLUE);
            rstl.setText("You Are Falling in SAFE SECTION. \n");
            rstl.setTextColor(Color.BLACK);
            rstl.append("Irrespective of whatever your result is,Please Follow Government Guidelines to be Safe. \n");
            rstl.append("Stay Home,Stay Safe");

        }
        else if (cnt>=21 && cnt<=40)
        {
            rstl.setTextColor(Color.DKGRAY);
            rstl.setText("You Are Falling in MODERATE SECTION. Better To Go for a Medical Checkup. \n");
            rstl.setTextColor(Color.BLACK);
            rstl.append("Irrespective of whatever your result is,Please Follow Government Guidelines to be Safe. \n");
            rstl.append("Stay Home,Stay Safe");

        }
        else {
            rstl.setTextColor(Color.RED);
            rstl.setText("You Are Falling in RISK SECTION CALL 911 As Soon As Possible. \n");
            rstl.setTextColor(Color.BLACK);
            rstl.append("Irrespective of whatever your result is,Please Follow Government Guidelines to be Safe. \n");
            rstl.append("Stay Home,Stay Safe");

        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)


    public void loadHome(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    public void call(View view) {

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:911"));
        startActivity(callIntent);
    }
}