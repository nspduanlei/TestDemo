package com.duanlei.guolindemo.removeView;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RemoteViews;

import com.duanlei.guolindemo.R;
import com.duanlei.guolindemo.WelcomeActivity;

/**
 * Author: duanlei
 * Date: 2015-12-15
 */
public class RemoveViewActivity extends Activity {


    class myHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_view);

        findViewById(R.id.btn_show_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification();
            }
        });

        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                return false;
            }
        });


    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void createNotification() {
        Notification.Builder builder = new Notification.Builder(this)
                .setTicker("有通知到了")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis());

        Intent notificationIntent = new Intent(this, WelcomeActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(RemoveViewActivity.this, 0
                , notificationIntent, 0);

        //自定义通知很简单，首先我们要提供一个布局文件，然后通过RemoteViews来加载这个布局文件即可改变
        //通知的样式

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.layout_notification);

        remoteViews.setTextViewText(R.id.msg, "chapter_5");
        remoteViews.setImageViewResource(R.id.icon, R.mipmap.ic_launcher);


        remoteViews.setOnClickPendingIntent(R.id.open_activity2, pendingIntent);

        Notification notification = builder.setContentIntent(pendingIntent).build();

        notification.contentView = remoteViews;


        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, notification);
    }


}
