package com.example.thsensor.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Here is the control screen.");
        // append or update device
        // call the bridage
        // map with all devices
    }

    public LiveData<String> getText() {
        return mText;
    }
}