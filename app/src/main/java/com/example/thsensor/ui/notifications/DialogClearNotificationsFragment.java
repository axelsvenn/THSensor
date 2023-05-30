package com.example.thsensor.ui.notifications;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.thsensor.R;
import com.example.thsensor.data.MyDevice;

public class DialogClearNotificationsFragment extends DialogFragment {

    MyDevice myDevice;

    public DialogClearNotificationsFragment(MyDevice myDevice) {
        this.myDevice = myDevice;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle(getResources().getText(R.string.clearDialog_title))
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setView(R.layout.dialog_clear_notifications)
                .setPositiveButton(getResources().getText(R.string.clearDialog_agree), (dialog, which) -> myDevice.clearNotifications())
                .setNegativeButton(getResources().getText(R.string.clearDialog_disagree), null)
                .setMessage(getResources().getText(R.string.clearDialog_text) + " " + myDevice.getIdString() + "?")
                .create();
    }


}
