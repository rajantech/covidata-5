package com.example.covidata.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.covidata.R;

public class aboutFragment extends Fragment {

    private aboutViewModel shareViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(aboutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        //final TextView textView = root.findViewById(R.id.text_share);

        return root;
    }
}