package com.example.thsensor.server.services;

import com.example.thsensor.data.MyDevice;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface NotificationService {
    @POST("/notification")
    @FormUrlEncoded
    public Call<List<MyDevice.Notification>> notifications(
                                        @Field("id") Long id,
                                        @Field("device_id") Long deviceID,
                                        @Field("date") Date date,
                                        @Field("time") Date time,
                                        @Field("text") String text);

    @PUT("/notification")
    Call<Void> saveNotification(@Body MyDevice.Notification notification);
}
