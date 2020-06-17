package com.example.covidata.ui.countries;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CountriesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CountriesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Countries fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}