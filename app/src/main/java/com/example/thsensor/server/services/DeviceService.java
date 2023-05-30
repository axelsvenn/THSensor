package com.example.thsensor.server.services;

import com.example.thsensor.data.entity.MyDevice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DeviceService {

    @GET("/device")
    Call<List<MyDevice>> getDevices(@Query("id") Long id);

    @GET("/device")
    Call<List<MyDevice>> getDevices();

    @PUT("/device")
    Call<Void> saveDevice(@Body MyDevice myDevice);

    @DELETE("/device")
    Call<Void> deleteDevice(@Path("id") Long id);
}
