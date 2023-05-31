package com.example.thsensor.ui.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.thsensor.R;
import com.example.thsensor.data.entity.MyDevice;
import com.example.thsensor.data.entity.Notification;
import com.example.thsensor.data.entity.ResponseHandler;
import com.example.thsensor.data.provider.DataHelper;

import java.util.ArrayList;
import java.util.List;

public class NotificationsAdapter extends ArrayAdapter<Notification> implements ResponseHandler<List<Notification>> {
    TextView deviceID, date, time, text;
    Button btnRead;
    ArrayList<Notification> notifications = new ArrayList<>();

    public NotificationsAdapter(@NonNull Context context, MyDevice myDevice) {
        super(context, R.layout.adapter_notifications, DataHelper.getDeviceNotifications(myDevice.getId()));


        if (myDevice.getId() == 0L) {
            notifications.addAll(DataHelper.getAllNotifications(this));
        } else {
            notifications.addAll(DataHelper.getDeviceNotifications(this, myDevice.getId()));
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_notifications, parent, false);
        }

        deviceID = convertView.findViewById(R.id.notificationDeviceID_info);
        date = convertView.findViewById(R.id.notificationDate_info);
        time = convertView.findViewById(R.id.notificationTime_info);
        text = convertView.findViewById(R.id.notificationText_info);
        btnRead = convertView.findViewById(R.id.btnClearLonerNotification);

        Notification item = getItem(position);

        deviceID.setText(item.getDevice_idString());
        date.setText(item.getDate());
        time.setText(item.getTime());
        text.setText(item.getText());
        btnRead.setOnClickListener(v -> {
            item.deleteNotification(response -> {
                DataHelper.getAllNotifications(this);
            });
        });

        return convertView;
    }

    @Override
    public void process(List<Notification> response) {

        notifications.clear();
        notifications.addAll(response);
        this.notifyDataSetChanged();
    }
}
