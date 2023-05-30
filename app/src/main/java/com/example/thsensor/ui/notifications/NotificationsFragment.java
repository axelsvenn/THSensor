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

import com.example.thsensor.databinding.FragmentNotificationsBinding;
import com.example.thsensor.data.DataHelper;
import com.example.thsensor.data.MyDevice;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private MyDevice myDevice = null;
    private ArrayAdapter<MyDevice.Notification> adapter = null;

    public NotificationsFragment() { }

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

        {
            if (myDevice == null) adapter = new NotificationsAdapter(
                    binding.getRoot().getContext(),
                    DataHelper.getAllNotifications()
            );
            else adapter = new NotificationsAdapter(
                    binding.getRoot().getContext(),
                    (ArrayList<MyDevice.Notification>) myDevice.getNotifications()
            );
        }

        listView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}