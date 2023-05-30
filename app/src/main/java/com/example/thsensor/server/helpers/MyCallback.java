package com.example.thsensor.server.helpers;

import retrofit2.Call;
import retrofit2.Callback;

public interface MyCallback<T> extends Callback<T> {

    @Override
    default void onFailure(Call<T> call, Throwable t) {
        t.printStackTrace();
    }
}
