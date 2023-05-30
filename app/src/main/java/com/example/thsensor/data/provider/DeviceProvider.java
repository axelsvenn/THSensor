package com.example.thsensor.data.provider;

import com.example.thsensor.data.entity.MyDevice;
import com.example.thsensor.data.entity.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

interface DeviceProvider extends DataProvider<MyDevice> {
    @Override
    ArrayList<MyDevice> selectAll(ResponseHandler<List<MyDevice>> responseHandler);
    @Override
    void deleteAll();

    @Override
    MyDevice selectSingle(ResponseHandler<List<MyDevice>> responseHandler, Long id);

    @Override
    void deleteSingle(Long id);

    @Override
    ArrayList<MyDevice> selectPart(ResponseHandler<List<MyDevice>> responseHandler, Long id);
    @Override
    void deletePart(Long id);
}
