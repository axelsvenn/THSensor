package com.example.thsensor.server.services;

import com.example.thsensor.data.MyDevice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface DeviceService {

    @GET("/device")
    Call<MyDevice> getSingleDevice(@Query("id") Long id);

    @GET("/device")
    Call<List<MyDevice>> getDevices();


    @PUT("/device")
    Call<Void> saveDevice(@Body MyDevice myDevice);
}
