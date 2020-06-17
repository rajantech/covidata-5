package com.example.covidata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class test4 extends AppCompatActivity {
int cnt;
DatabaseReference databaseReference;
int a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
        cnt = getIntent().getExtras().getInt("count");
        databaseReference= FirebaseDatabase.getInstance().getReference().child("assesment").child("sorethroat");

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
                cnt = cnt + 3;
                Intent intent = new Intent(getApplicationContext(), test5.class);
                intent.putExtra("count", cnt);
                startActivity(intent);
                break;
            case R.id.button2:
                databaseReference.child("no").setValue(String.valueOf(b+1));
                cnt = cnt + 0;
                Intent intent1 = new Intent(getApplicationContext(), test5.class);
                intent1.putExtra("count", cnt);
                startActivity(intent1);

                break;

        }
    }
}
