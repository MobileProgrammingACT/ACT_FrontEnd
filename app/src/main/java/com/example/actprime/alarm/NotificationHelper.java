package com.example.actprime.alarm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.actprime.R;

public class NotificationHelper extends ContextWrapper {
    public static final String channelID = "channelID";
    public static final String channelNm = "chanelNm";

    private NotificationManager notificationManager;

    public NotificationHelper(Context base) {
        super(base);
        // 안드로이드 버전 오레오 or 이상이면 채널생성
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d("testt", "채널 생성");
            createChannels();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannels() {
        NotificationChannel channel1 = new NotificationChannel(channelID,channelNm,NotificationManager.IMPORTANCE_DEFAULT);
        channel1.enableLights(true);
        channel1.enableVibration(true);
        channel1.setLightColor(R.color.white);
        channel1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channel1);
    }

    public NotificationManager getManager() {
        if (notificationManager == null) {
            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return notificationManager;
    }

    public NotificationCompat.Builder getChannelNotification() {
        return new NotificationCompat.Builder(getApplicationContext(),channelID)
                .setContentTitle("해요!")
                .setContentText("오늘의 활동을 시작하세요!")
                .setSmallIcon(R.drawable.haeyo_remove);
    }
}
