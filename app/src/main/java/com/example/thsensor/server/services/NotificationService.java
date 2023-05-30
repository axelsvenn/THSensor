package com.example.thsensor.server.services;

import com.example.thsensor.data.entity.Notification;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NotificationService {
    @GET("/notification")
    public Call<List<Notification>> getNotifications();

    @GET("/notification")
    public Call<List<Notification>> getNotifications(@Query("id") Long id);

    @PUT("/notification")
    Call<Void> saveNotification(@Body Notification notification);

    @DELETE("/notification")
    Call<Void> deleteNotification(@Path("id") Long id);
}
