package com.example.thsensor.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.thsensor.data.provider.DataHelper;
import com.example.thsensor.data.entity.MyDevice;
import com.example.thsensor.data.entity.Notification;
import com.example.thsensor.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private MyDevice myDevice = null;
    private ArrayAdapter<Notification> adapter = null;

    public NotificationsFragment() {
    }

    public NotificationsFragment(MyDevice myDevice) {
        this.myDevice = myDevice;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ListView listView = binding.notificationsListView;
        notificationsViewModel.getMessages().observe(getViewLifecycleOwner(), myMessages -> {
            // describe mechanics of logging
        });

        if (myDevice == null) {
            myDevice = new MyDevice("-", "-", 0L);
            myDevice.setNotifications(DataHelper.getAllNotifications());
        }

        adapter = new NotificationsAdapter(getContext(), myDevice);

        listView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}