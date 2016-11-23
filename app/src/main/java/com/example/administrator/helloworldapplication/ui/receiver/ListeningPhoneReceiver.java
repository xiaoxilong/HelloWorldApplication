package com.example.administrator.helloworldapplication.ui.receiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class ListeningPhoneReceiver extends BroadcastReceiver {
    private static final String TAG = ListeningPhoneReceiver.class.getSimpleName();

    public ListeningPhoneReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
        tm.listen(new PhoneStateListener(){

            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                Log.d(TAG, "onCallStateChanged: "+incomingNumber);//获得来电的电话

                super.onCallStateChanged(state, incomingNumber);

            }
        },PhoneStateListener.LISTEN_CALL_STATE);

    }
}
