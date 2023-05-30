package com.example.thsensor.ui.notifications;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import com.example.thsensor.R;
import com.example.thsensor.data.MyDevice;

public class DialogNotificationsFragment extends DialogFragment {

    private MyDevice myDevice;
    private View view;

    public DialogNotificationsFragment(MyDevice myDevice) {
        this.myDevice = myDevice;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        view = getLayoutInflater().inflate(R.layout.dialog_notifications, null);

        AlertDialog d = builder
                .setView(view)
                .setTitle(getResources().getText(R.string.dialog_title))
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(getResources().getText(R.string.dialog_agree), null)
                .setNeutralButton(getResources().getText(R.string.dialog_clear), (dialog, which) -> myDevice.clearNotifications())
                .create();


        //getChildFragmentManager().beginTransaction().add(R.id.fragmentContainerView, notificationsFragment).commit();

        return d;
    }

    @Override
    public void onResume() {
        super.onResume();
        ConstraintLayout fragmentContainerView = view.findViewById(R.id.fragmentContainerDialogNotifications);
        NotificationsFragment notificationsFragment = new NotificationsFragment(this.myDevice);
        getChildFragmentManager().beginTransaction().add(fragmentContainerView.getId(), notificationsFragment).commit();
    }
}
