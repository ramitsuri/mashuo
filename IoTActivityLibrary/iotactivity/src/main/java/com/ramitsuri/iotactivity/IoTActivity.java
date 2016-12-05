package com.ramitsuri.iotactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by ramitsuri on 11/29/2016.
 */

public class IoTActivity extends AppCompatActivity {
    public void startMyService(){
        Intent intent = new Intent();
        intent.setClass(this, IoTService.class);
        startService(intent);
        Toast.makeText(this, "Hello Iot", Toast.LENGTH_SHORT).show();
    }
}
