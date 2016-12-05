package com.ramitsuri.iotactivity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class IoTService extends Service {
    public static String LAYOUT_EXTRA = "layout_extra";
    public static String LAYOUT_ACTIVITY_ID = "-1";
    public static String REMOTE_LAYOUT = "";
    public IoTService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static void executeRestCall() {
        String url = "http://52.39.204.2:1398/activity/" + LAYOUT_ACTIVITY_ID;
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            REMOTE_LAYOUT = response.body().string();
        }
        catch (IOException ex){
            //return "";
        }
    }
}
