package com.example.thsensor.ui.devices;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.thsensor.data.MyDevice;

import java.util.ArrayList;

public class DevicesViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<MyDevice>> devices;

    public DevicesViewModel() {
        devices = new MutableLiveData<>();
    }

    public LiveData<ArrayList<MyDevice>> getDevices() {
        return devices;
    }
}
