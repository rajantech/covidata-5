package com.example.covidata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class test1 extends AppCompatActivity {
    Button btnYes, btnNo;
     int cnt;
    int a,b;
     DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        btnYes = findViewById(R.id.button);
        btnNo = findViewById(R.id.button2);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("assesment").child("fever");

        cnt = 0;

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            a= Integer.valueOf(dataSnapshot.child("yes").getValue().toString());
   b=Integer.valueOf(dataSnapshot.child("no").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadTest(View view) {
        switch (view.getId()) {
            case R.id.button:
             databaseReference.child("yes").setValue(String.valueOf(a+1));

                cnt = cnt + 6;
                Intent intent = new Intent(getApplicationContext(), test2.class);
                intent.putExtra("count", cnt);
               startActivity(intent);
                break;
            case R.id.button2:
                databaseReference.child("no").setValue(String.valueOf(b+1));
                cnt = cnt + 0;
                Intent intent1 = new Intent(getApplicationContext(), test2.class);
                intent1.putExtra("count", cnt);
               startActivity(intent1);

                break;

        }
    }
}
