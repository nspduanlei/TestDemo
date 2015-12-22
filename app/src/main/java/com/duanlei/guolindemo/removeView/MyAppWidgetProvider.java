package com.duanlei.guolindemo.removeView;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.duanlei.guolindemo.R;

/**
 * Author: duanlei
 * Date: 2015-12-15
 */
public class MyAppWidgetProvider extends AppWidgetProvider {

    public static final String TAG = "MyAppWidgetProvider";
    public static final String CLICK_ACTION = "com.dl.chapter_5.action.CLICK";

    public MyAppWidgetProvider() {

    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        super.onReceive(context, intent);

        Log.d(TAG, "onReceive : action = " + intent.getAction());


        if (intent.getAction().equals(CLICK_ACTION)) {
            Toast.makeText(context, "clicked it", Toast.LENGTH_SHORT).show();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    Bitmap srcbBitmap = BitmapFactory.decodeResource(
                            context.getResources(), R.mipmap.icon1
                    );

                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

                    for (int i = 0; i < 37; i++) {

                        float degree = (i * 10) % 360;

                        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                                R.layout.widget);

                        remoteViews.setImageViewBitmap(R.id.imageView1,
                                rotateBitmap(context, srcbBitmap, degree));

                        Intent intentClick = new Intent();
                        intentClick.setAction(CLICK_ACTION);

                        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                                context, 0, intentClick, 0
                        );

                        remoteViews.setOnClickPendingIntent(R.id.imageView1, pendingIntent);

                        appWidgetManager.updateAppWidget(new ComponentName(
                                        context, MyAppWidgetProvider.class),
                                remoteViews
                        );

                        SystemClock.sleep(30);

                    }
                }
            }).start();
        }
    }

    private Bitmap rotateBitmap(Context context, Bitmap srcbBitmap, float degree) {
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(degree);
        return Bitmap.createBitmap(srcbBitmap, 0, 0,
                srcbBitmap.getWidth(), srcbBitmap.getHeight(), matrix, true);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        Log.i(TAG, "onUpdate");

        final int counter = appWidgetIds.length;
        for (int appWidgetId : appWidgetIds) {
            onWidgetUpdate(context, appWidgetManager, appWidgetId);
        }
    }

    private void onWidgetUpdate(Context context,
                                AppWidgetManager appWidgetManager, int appWidgetId) {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);

        Intent intentClick = new Intent();
        intentClick.setAction(CLICK_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intentClick, 0);

        remoteViews.setOnClickPendingIntent(R.id.imageView1, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }


}
