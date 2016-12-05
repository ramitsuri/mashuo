package com.ramitsuri.iotactivity;

import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by ramitsuri on 12/4/2016.
 */

public class DetectionService extends FirebaseMessagingService {
    public DetectionService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //Toast.makeText(this, remoteMessage.getNotification().getBody().toString(), Toast.LENGTH_SHORT).show();
        Log.d("hi", "message received");
        IoTService.LAYOUT_ACTIVITY_ID = remoteMessage.getNotification().getBody();
        IoTService.executeRestCall();
    }
    private void sendNotification(String title, String messageBody) {

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }

}
