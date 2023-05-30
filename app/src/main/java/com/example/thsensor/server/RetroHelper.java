package com.example.thsensor.server;

import static com.example.thsensor.MAIN_CONSTANTS.DATABASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroHelper {  // singleton
    private static Retrofit instance = null;

    private RetroHelper() { }

    public static Retrofit getServer() {
        if (instance == null) instance = new Retrofit.Builder()
                .baseUrl(DATABASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return instance;
    }
}