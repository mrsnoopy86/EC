package com.smithysoft.englishclub.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.View;

import com.smithysoft.englishclub.R;
import com.smithysoft.englishclub.activity.StartScreen;
import com.smithysoft.englishclub.newactivity.LoginScreen;

/**
 * Created by Philip on 13.07.2015.
 */
public class AppNotification {
    Context context;
    private NotificationManager nm;
    private final int NOTIFICATION_ID = 123;

    public AppNotification(Context context) {
        this.context = context;
    }

    public void showNotification() {
        nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        android.app.Notification.Builder builder = new android.app.Notification.Builder(context);
        Intent intent = new Intent(context, StartScreen.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        builder
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_youtube_button)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_youtube_button))
                .setTicker("You hawe a massage!")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Some massage!")
                .setContentText("Look here for more details.");
        android.app.Notification notification = builder.build();
        notification.defaults = android.app.Notification.DEFAULT_ALL;

        nm.notify(NOTIFICATION_ID,notification);
    }
}
