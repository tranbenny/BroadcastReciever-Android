package com.example.airwreck.ebalarm;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    AlarmManager mAlarmManager;
    public static final int MY_ALARM = 123;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent alarmFiredIntent = new Intent(this, MyReceiver.class);
        // context, requestCode: used for identifying this pending intent, pending intent flag
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, MY_ALARM, alarmFiredIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // canceling a pending intent to make sure it doesn't get fired
        // pendingIntent.cancel();

        // sends a repeating alarm every 10 seconds
        mAlarmManager.setRepeating(AlarmManager.RTC,System.currentTimeMillis(),  10000, pendingIntent);


        // create a new receiver
        MyReceiver myReceiver = new MyReceiver();
        // registerReceiver(myReceiver);
        // can set intent filters for the reciever in the manifest file, lots of different events
        // manually adding intent filte
        IntentFilter filter = new IntentFilter();
        filter.addFilter(DOWNLOAD_SERVICE);

        registerReceiver(receiver, intentFilter);


    }
}
