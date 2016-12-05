package com.ramitsuri.iotactivitylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ramitsuri.iotactivity.IoTActivity;
import com.ramitsuri.iotactivity.IoTService;

import static com.ramitsuri.iotactivity.IoTService.LAYOUT_EXTRA;
import static com.ramitsuri.iotactivity.IoTService.REMOTE_LAYOUT;

public class MainActivity extends IoTActivity  implements View.OnClickListener{

    Button buttonLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.startMyService();
        buttonLaunch = (Button)findViewById(R.id.buttonLaunch);
        buttonLaunch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String layout = IoTService.LAYOUT_ACTIVITY_ID;
        String layouts = IoTService.REMOTE_LAYOUT;

        Intent launchIntent = new Intent();
        launchIntent.putExtra(LAYOUT_EXTRA, REMOTE_LAYOUT);
        launchIntent.setClass(this, EmptyActivity.class);
        startActivity(launchIntent);
    }

}
