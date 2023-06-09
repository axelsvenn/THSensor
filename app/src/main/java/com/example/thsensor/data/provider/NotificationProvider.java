package com.example.thsensor.data.provider;

import com.example.thsensor.data.entity.Notification;
import com.example.thsensor.data.entity.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

interface NotificationProvider extends DataProvider<Notification> {
    @Override
    ArrayList<Notification> selectAll(ResponseHandler<List<Notification>> responseHandler);
    @Override
    void deleteAll();
    @Override
    Notification selectSingle(ResponseHandler<List<Notification>> responseHandler, Long id);

    @Override
    void deleteSingle(Long id, ResponseHandler<Void> responseHandler);

    @Override
    ArrayList<Notification> selectPart(ResponseHandler<List<Notification>> responseHandler, Long id);
    @Override
    void deletePart(Long device_id);

    List<Notification> getDeviceNotifications(ResponseHandler<List<Notification>> responseHandler, Long device_id);
}
