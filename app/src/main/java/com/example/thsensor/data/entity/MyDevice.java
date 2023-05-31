package com.example.thsensor.data.entity;


import com.example.thsensor.data.provider.DataHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDevice {
    private String name, location;
    private Long id;

    private List<Notification> notifications;

    public MyDevice(String name, String location, Long id) {
        this.name = name;
        this.location = location;
        this.id = id;
    }

    protected boolean hasNotification() {
        return notifications.isEmpty();
    }

    public void clearNotifications() {
        DataHelper.deleteDeviceNotifications(this.getId());
    }

    public void addNotification(String date, String time, String text) {
        if (notifications == null) notifications = new ArrayList<>();

        this.notifications.add(new Notification(date, time, text, this.getId()));
    }

    public List<Notification> getNotifications() {
        if (notifications == null) {
            notifications = new ArrayList<>();
        }
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Long getId() {
        return id;
    }

    public String getIdString() {
        return "" + this.getId();
    }
}
