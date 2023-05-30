package com.example.thsensor.data.provider;

import com.example.thsensor.data.MyDevice;
import com.example.thsensor.data.ResponseHandler;
import com.example.thsensor.server.RetroHelper;
import com.example.thsensor.server.helpers.MyCallback;
import com.example.thsensor.server.services.DeviceService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class ServerDeviceProvider implements DeviceProvider {
    private Retrofit retrofit = RetroHelper.getServer();
    private DeviceService service = retrofit.create(DeviceService.class);

    @Override
    public ArrayList<MyDevice> selectAll(ResponseHandler<List<MyDevice>> responseHandler) {

        ArrayList<MyDevice> devices = new ArrayList<>();

        Call<List<MyDevice>> call = service.getDevices();

        call.enqueue((MyCallback<List<MyDevice>>) (call1, response) -> {
            List<MyDevice> body = response.body();

            devices.addAll(body);
            responseHandler.process(devices);
        });


        return devices;
    }
}
