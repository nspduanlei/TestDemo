package com.duanlei.guolindemo;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Author: duanlei
 * Date: 2015-11-27
 */
public class MyService extends Service {

    public static final String TAG = "MyService";

    //private MyBinder mBinder = new MyBinder();

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onCreate() {
        super.onCreate();

        //前台Service

        Notification.Builder builder = new Notification.Builder(this)
                .setTicker("有通知到了")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis());

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0
            ,notificationIntent, 0);


        //api 16以上，.build()方法要求api 16及以上
        Notification notification = builder.setContentIntent(pendingIntent)
                .setContentTitle("这是通知的标题").setContentText("这是通知的内容").build();


        startForeground(1, notification);

        Log.d(TAG, "onCreate() executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() executed");

        new Thread(new Runnable() {
            @Override
            public void run() {
                //开始执行后台任务
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() executed");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

//    class MyBinder extends Binder {
//
//        public void startDownload() {
//            Log.d("TAG", "startDownload() executed");
//            //执行具体的下载任务
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    //执行下载任务
//                }
//            }).start();
//        }
//    }

    MyAIDLService.Stub mBinder = new MyAIDLService.Stub() {
        @Override
        public int plus(int a, int b) throws RemoteException {
            return a + b;
        }

        @Override
        public String toUpperCase(String str) throws RemoteException {

            if (str != null) {
                return str.toUpperCase();
            }
            return null;
        }
    };


}
