package com.example.covidata.ui.assesment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.covidata.R;
import com.example.covidata.*;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class assesmentTools extends Fragment {
TextView fyes,fno, coyes,cono, tiyes,tino, soyes, sono, muyes, muno, loyes, lono, diyes,dino, sbyes, sbno, cpyes, cpno, smyes, smno;
    DatabaseReference databaseReference;
Button loadTest;
    public assesmentTools() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_assesment_tools, container, false);

        loadTest = view.findViewById(R.id.loadTest);
        fyes = view.findViewById(R.id.fyes);
        fno = view.findViewById(R.id.fno);
        coyes= view.findViewById(R.id.coyes);
        cono= view.findViewById(R.id.cono);
        tino= view.findViewById(R.id.tino);
        tiyes= view.findViewById(R.id.tiyes);
        soyes= view.findViewById(R.id.soyes);
        sono= view.findViewById(R.id.sono);
        muyes= view.findViewById(R.id.muyes);
        muno= view.findViewById(R.id.muno);
        loyes= view.findViewById(R.id.loyes);
        lono= view.findViewById(R.id.lono);
        diyes= view.findViewById(R.id.diyes);
        dino= view.findViewById(R.id.dino);
        sbyes= view.findViewById(R.id.sbyes);
        sbno= view.findViewById(R.id.sbno);
        cpyes= view.findViewById(R.id.cpyes);
        cpno= view.findViewById(R.id.cpno);
        smyes= view.findViewById(R.id.smyes);
        smno= view.findViewById(R.id.smno);

 //= view.findViewById(R.id.);



        databaseReference= FirebaseDatabase.getInstance().getReference().child("assesment");//.child("lossofmovement");

        databaseReference.child("fever").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                fyes.setText(dataSnapshot.child("yes").getValue().toString());
                fno.setText(dataSnapshot.child("no").getValue().toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        databaseReference.child("chestpain").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cpyes.setText(dataSnapshot.child("yes").getValue().toString());
                cpno.setText(dataSnapshot.child("no").getValue().toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("cough").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                coyes.setText(dataSnapshot.child("yes").getValue().toString());
                cono.setText(dataSnapshot.child("no").getValue().toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        databaseReference.child("diarrhea").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                diyes.setText(dataSnapshot.child("yes").getValue().toString());
                dino.setText(dataSnapshot.child("no").getValue().toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        databaseReference.child("lossofmovement").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                smyes.setText(dataSnapshot.child("yes").getValue().toString());
                smno.setText(dataSnapshot.child("no").getValue().toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("lossofsmell").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                loyes.setText(dataSnapshot.child("yes").getValue().toString());
                lono.setText(dataSnapshot.child("no").getValue().toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("muscleaches").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                muyes.setText(dataSnapshot.child("yes").getValue().toString());
                muno.setText(dataSnapshot.child("no").getValue().toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.child("shortnessofbreath").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                sbyes.setText(dataSnapshot.child("yes").getValue().toString());
                sbno.setText(dataSnapshot.child("no").getValue().toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        databaseReference.child("sorethroat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                soyes.setText(dataSnapshot.child("yes").getValue().toString());
                sono.setText(dataSnapshot.child("no").getValue().toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        databaseReference.child("tiredness").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tiyes.setText(dataSnapshot.child("yes").getValue().toString());
                tino.setText(dataSnapshot.child("no").getValue().toString());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        loadTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), test1.class);
                startActivity(i);
            }
        });





        return view;
    }

}
