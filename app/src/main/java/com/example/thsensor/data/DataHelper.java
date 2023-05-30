package com.example.thsensor.data;

import com.example.thsensor.data.provider.DeviceProvider;
import com.example.thsensor.data.provider.ServerDeviceProvider;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    private static DeviceProvider deviceProvider;

    static {
        deviceProvider = new ServerDeviceProvider();
    }

    public static ArrayList<MyDevice> getDevices(ResponseHandler<List<MyDevice>> responseHandler) {
        return deviceProvider.selectAll(responseHandler);
    }


    public static ArrayList<MyDevice> getDevices() {

        return DataHelper.getDevices(response -> {

        });
    }

    public static ArrayList<MyDevice.Notification> getAllNotifications() {
        ArrayList<MyDevice.Notification> notifications = new ArrayList<>();
        for (MyDevice myDevice: DataHelper.getDevices()) notifications.addAll(myDevice.getNotifications());

        return notifications;
    }

    public static void clearAllMessages() {
        for (MyDevice myDevice: DataHelper.getDevices()) myDevice.clearNotifications();
    }
}
