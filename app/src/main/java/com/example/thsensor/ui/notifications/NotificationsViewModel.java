package com.example.thsensor.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.thsensor.data.entity.Notification;

import java.util.ArrayList;

public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<Notification>> notifications;

    public NotificationsViewModel() {
        notifications = new MutableLiveData<>();
    }

    public LiveData<ArrayList<Notification>> getMessages() {
        return notifications;
    }
}