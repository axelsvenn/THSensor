package com.example.thsensor.ui.device;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.thsensor.data.provider.DataHelper;
import com.example.thsensor.data.entity.MyDevice;
import com.example.thsensor.databinding.FragmentDeviceBinding;
import com.example.thsensor.ui.devices.DevicesAdapter;

public class DeviceFragment extends Fragment {

    private FragmentDeviceBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DeviceViewModel deviceViewModel =
                new ViewModelProvider(this).get(DeviceViewModel.class);

        binding = FragmentDeviceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayAdapter<MyDevice> adapter = new DevicesAdapter(
                this,
                DataHelper.getDevices(response -> ((ArrayAdapter) binding.deviceListView.getAdapter()).notifyDataSetChanged())
        );

        binding.deviceListView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}