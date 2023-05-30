package com.example.thsensor.data.provider;

import android.provider.ContactsContract;

import com.example.thsensor.data.entity.Notification;
import com.example.thsensor.data.entity.ResponseHandler;
import com.example.thsensor.server.RetroHelper;
import com.example.thsensor.server.helpers.MyCallback;
import com.example.thsensor.server.services.NotificationService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

class ServerNotificationProvider implements NotificationProvider {
    private Retrofit retrofit = RetroHelper.getServer();
    private NotificationService service = retrofit.create(NotificationService.class);
    private ArrayList<Notification> notifications = new ArrayList<>();

    @Override
    public ArrayList<Notification> selectAll(ResponseHandler<List<Notification>> responseHandler) {
        Call<List<Notification>> call = service.getNotifications();

        call.enqueue((MyCallback<List<Notification>>) (call1, response) -> {
            List<Notification> body = response.body();
            notifications.clear();

            notifications.addAll(body);
            responseHandler.process(notifications);
        });


        return notifications;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Notification selectSingle(ResponseHandler<List<Notification>> responseHandler, Long id) {
        Call<List<Notification>> call = service.getNotifications(id);

        call.enqueue((MyCallback<List<Notification>>) (call1, response) -> {
            List<Notification> body = response.body();
            notifications.clear();

            notifications.addAll(body);
            responseHandler.process(notifications);
        });


        return notifications.get(0);
    }

    @Override
    public void deleteSingle(Long id, ResponseHandler<Void> responseHandler) {
        service.deleteNotification(id).enqueue((MyCallback<Void>) (call, response) -> {
                responseHandler.process(null);
        });
    }

    @Override
    public ArrayList<Notification> selectPart(ResponseHandler<List<Notification>> responseHandler, Long device_id) {
        return null;
    }

    @Override
    public void deletePart(Long device_id) {

    }

    @Override
    public List<Notification> getDeviceNotifications(ResponseHandler<List<Notification>> responseHandler, Long device_id) {
        Call<List<Notification>> call = service.getDeviceNotifications(device_id);

        call.enqueue((MyCallback<List<Notification>>) (call1, response) -> {
            List<Notification> body = response.body();
            notifications.clear();

            notifications.addAll(body);
            responseHandler.process(notifications);
        });


        return notifications;
    }
}
