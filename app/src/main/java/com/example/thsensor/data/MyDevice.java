package com.example.thsensor.data;

import java.util.ArrayList;
import java.util.List;

public class MyDevice {
    private String name, location;
    private final Long id;

    private List<Notification> notifications;

    public MyDevice(String name, String location, Long id) {
        this.name = name;
        this.location = location;
        this.id = id;
    }

    protected boolean hasNotification() {
        return this.notifications.isEmpty();
    }

    public void clearNotifications() {
        this.notifications.clear();
    }

    public void addNotification(String date, String time, String text) {
        if (notifications == null) notifications = new ArrayList<>();

        this.notifications.add(new Notification(date, time, text));
    }

    public List<Notification> getNotifications() {
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

    public void deleteMessage(Notification notification) {
        notifications.remove(notification);
    }

    public class Notification {
        private Long deviceID = id;
        private String date, time;
        private String text;

        public Notification(String date, String time, String text) {
            this.date = date;
            this.time = time;
            this.text = text;
        }

        public Long getDeviceID() {
            return deviceID;
        }

        public String getDeviceIDString() {
            return "" + this.getDeviceID();
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void deleteNotification() {
            deleteMessage(this);
        }
    }
}
