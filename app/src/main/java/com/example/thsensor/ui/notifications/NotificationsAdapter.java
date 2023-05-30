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
import com.example.thsensor.data.MyDevice;

import java.util.ArrayList;

public class NotificationsAdapter extends ArrayAdapter<MyDevice.Notification> {
    TextView deviceID, date, time, text;
    Button btnRead;

    public NotificationsAdapter(@NonNull Context context, ArrayList<MyDevice.Notification> notifications) {
        super(context, R.layout.adapter_notifications, notifications);
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

        MyDevice.Notification item = getItem(position);

        deviceID.setText(item.getDeviceIDString());
        date.setText(item.getDate());
        time.setText(item.getTime());
        text.setText(item.getText());
        btnRead.setOnClickListener(v -> {
            item.deleteNotification();
            this.notifyDataSetChanged();
        });

        return convertView;
    }
}
