package com.example.thsensor.ui.devices;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.thsensor.R;
import com.example.thsensor.data.entity.MyDevice;
import com.example.thsensor.ui.notifications.DialogNotificationsFragment;

import java.util.ArrayList;

public class DevicesAdapter extends ArrayAdapter<MyDevice> {

    FragmentActivity activity;
    TextView id, name, location;
    Button btnNoti;
    FragmentManager childFragmentManager;

    public DevicesAdapter(Fragment devicesFragment, ArrayList<MyDevice> devices) {
        super(devicesFragment.getContext(), R.layout.adapter_devices, devices);
        this.childFragmentManager = devicesFragment.getChildFragmentManager();
        this.activity = devicesFragment.getActivity();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_devices, parent, false);
        }

        id = convertView.findViewById(R.id.deviceID_info);
        name = convertView.findViewById(R.id.deviceName_info);
        location = convertView.findViewById(R.id.deviceLocation_info);
        btnNoti = convertView.findViewById(R.id.device_notificationButton);

        MyDevice item = getItem(position);

        id.setText(item.getIdString());
        name.setText(item.getName());
        location.setText(item.getLocation());


        btnNoti.setOnClickListener(v -> {
            DialogNotificationsFragment dialog = new DialogNotificationsFragment(item);
            dialog.show(childFragmentManager, "custom");
        });

        return convertView;
    }
}