package com.example.thsensor.ui.device;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DeviceViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DeviceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is device fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}