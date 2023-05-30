package com.example.thsensor.ui.devices;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.thsensor.R;
import com.example.thsensor.data.ResponseHandler;
import com.example.thsensor.databinding.FragmentDevicesBinding;
import com.example.thsensor.data.DataHelper;
import com.example.thsensor.data.MyDevice;
import com.example.thsensor.ui.device.DeviceFragment;

import java.util.List;


public class DevicesFragment extends Fragment {


    private FragmentDevicesBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DevicesViewModel devicesViewModel =
                new ViewModelProvider(this).get(DevicesViewModel.class);

        binding = FragmentDevicesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ListView listView = binding.devicesListView;
        devicesViewModel.getDevices().observe(getViewLifecycleOwner(), myDevices -> {
            // describe mechanics of logging
        });

        ArrayAdapter<MyDevice> adapter = new DevicesAdapter(
                this,
                DataHelper.getDevices(response -> ((ArrayAdapter) listView.getAdapter()).notifyDataSetChanged())
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Fragment deviceFragment = new DeviceFragment();
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.nav_host_fragment_activity_main, deviceFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}