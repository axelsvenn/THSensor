package com.example.thsensor.data.entity;

import com.example.thsensor.data.provider.DataHelper;

public class Notification {
    private Long id;
    private Long device_id;
    private String date, time;
    private String text;

    public Notification(String date, String time, String text, Long device_id) {
        this.date = date;
        this.time = time;
        this.text = text;
        this.device_id = device_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public String getDevice_idString() {
        return device_id.toString();
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
        for (MyDevice myDevice : DataHelper.getDevices()) {
            if (myDevice.getId().longValue() == device_id.longValue()) myDevice.deleteNotification(this);
        }
    }
}
