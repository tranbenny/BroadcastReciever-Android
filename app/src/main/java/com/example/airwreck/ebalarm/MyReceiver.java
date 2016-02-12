package com.example.airwreck.ebalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


// broadcast reviewer listeners for different events and calls method on recieve

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {


    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MYRECIEVER", "alarm is fired");

        // intent.getAction() == "TYPE OF EVENT";
    }
}
