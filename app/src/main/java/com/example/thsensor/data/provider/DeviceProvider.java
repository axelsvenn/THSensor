package com.example.thsensor.data.provider;

import com.example.thsensor.data.MyDevice;
import com.example.thsensor.data.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public interface DeviceProvider extends DataProvider<MyDevice> {
    ArrayList<MyDevice> selectAll(ResponseHandler<List<MyDevice>> responseHandler);
}
