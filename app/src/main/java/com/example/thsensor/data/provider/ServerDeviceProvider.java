package com.example.thsensor.data.provider;

import com.example.thsensor.data.entity.MyDevice;
import com.example.thsensor.data.entity.ResponseHandler;
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
    private ArrayList<MyDevice> devices = new ArrayList<>();

    @Override
    public ArrayList<MyDevice> selectAll(ResponseHandler<List<MyDevice>> responseHandler) {
        Call<List<MyDevice>> call = service.getDevices();

        call.enqueue((MyCallback<List<MyDevice>>) (call1, response) -> {
            List<MyDevice> body = response.body();
            devices.clear();

            devices.addAll(body);
            responseHandler.process(devices);
        });


        return devices;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public MyDevice selectSingle(ResponseHandler<List<MyDevice>> responseHandler, Long id) {
        Call<List<MyDevice>> call = service.getDevices(id);

        call.enqueue((MyCallback<List<MyDevice>>) (call1, response) -> {
            List<MyDevice> body = response.body();
            devices.clear();

            devices.addAll(body);
            responseHandler.process(devices);
        });


        return devices.get(0);
    }

    @Override
    public void deleteSingle(Long id) {
        service.deleteDevice(id);
    }
}
