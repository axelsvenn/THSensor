package com.example.thsensor.data.provider;

import com.example.thsensor.data.entity.MyDevice;
import com.example.thsensor.data.entity.Notification;
import com.example.thsensor.data.entity.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    private static DeviceProvider deviceProvider;
    private static NotificationProvider notificationProvider;

    static {
        deviceProvider = new ServerDeviceProvider();
        notificationProvider = new ServerNotificationProvider();
    }

    public static ArrayList<MyDevice> getDevices(ResponseHandler<List<MyDevice>> responseHandler) {
        return deviceProvider.selectAll(responseHandler);
    }

    public static ArrayList<MyDevice> getDevices() {
        return deviceProvider.selectAll(response -> {});
    }

    public static MyDevice getSingleDevice(ResponseHandler<List<MyDevice>> responseHandler, Long id) {
        return deviceProvider.selectSingle(responseHandler, id);
    }

    public static MyDevice getSingleDevice(Long id) {
        return deviceProvider.selectSingle(response -> {}, id);
    }

    public static ArrayList<Notification> getAllNotifications(ResponseHandler<List<Notification>> responseHandler) {
        return notificationProvider.selectAll(responseHandler);
    }

    public static ArrayList<Notification> getAllNotifications() {
        return notificationProvider.selectAll(response -> {});
    }

    public static Notification getNotification(ResponseHandler<List<Notification>> responseHandler, Long id) {
        return notificationProvider.selectSingle(responseHandler, id);
    }

    public static ArrayList<Notification> getDeviceNotifications(ResponseHandler<List<Notification>> responseHandler, Long device_id) {
        if (device_id == 0) return getAllNotifications(responseHandler);

        return (ArrayList<Notification>) notificationProvider.getDeviceNotifications(responseHandler, device_id);
    }
    public static ArrayList<Notification> getDeviceNotifications(Long device_id) {

        return (ArrayList<Notification>) getDeviceNotifications(response -> {}, device_id);
    }

    public static void addNotification() {

    }

    public static void deleteAllNotifications() {
        for (MyDevice myDevice: DataHelper.getDevices()) myDevice.clearNotifications();
    }

    public static void deleteNotification(Long id, ResponseHandler<Void> responseHandler) {
        notificationProvider.deleteSingle(id, responseHandler);
    }

    public static void deleteDeviceNotifications(Long device_id) {

    }
}
