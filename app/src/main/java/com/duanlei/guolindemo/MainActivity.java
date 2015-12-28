package com.duanlei.guolindemo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.duanlei.guolindemo.four.MyReceiver;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myview);

//        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.main_layout);
//        LayoutInflater layoutInflater = LayoutInflater.from(this);
//        View buttonLayout = layoutInflater.inflate(R.layout.button_layout, null);
//        mainLayout.addView(buttonLayout);

        //showDialog(this);

        //new VolleyTest(this).postTest();


//        testWindow();

//        Handler myHandler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//            }
//        };


        //myHandler.obtainMessage(whart, obj).sendToTarget();

//        Intent intent = new Intent();
//        intent.setAction("android.intent.action.TEST");
//        startActivity(intent);
    }




    private static final String ACTIVITY_TEST = "com.dl.receiver.LAUNCH";

    //注册广播
    private void registerMyReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTIVITY_TEST);
        registerReceiver(new MyReceiver(), filter);
    }

    //发送广播
    private void sendMyReceiver() {
        Intent intent = new Intent();
        intent.setAction(ACTIVITY_TEST);
        sendBroadcast(intent);
    }

    //解除注册
    private void unregisterMyReceiver() {
        unregisterReceiver(new MyReceiver());
    }


    private void testActivity() {
        Intent intent = new Intent(this, MyView.class);
        startActivity(intent);
    }


    private void Test1() {
        //
        new DownloadTask().execute();

        //使用自定义的Executor执行异步任务
        Executor executor = new ThreadPoolExecutor(15, 200, 10,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        new DownloadTask().executeOnExecutor(executor);
    }


    private void showDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.mipmap.icon1);
        builder.setTitle("Title");
        builder.setMessage("Message");
        builder.setPositiveButton("Button1",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setTitle("点击了对话框上的Button1");
                    }
                });

        builder.setNeutralButton("Button2",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setTitle("点击了对话框上的Button2");
                    }
                });

        builder.setNegativeButton("Button3",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setTitle("点击了对话框上的Button3");
                    }
                });

        builder.create().show();
    }

    private void testWindow() {
        final Button button = new Button(this);
        button.setText("button");
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                0, 0, PixelFormat.TRANSPARENT
        );

        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;

        layoutParams.gravity = Gravity.LEFT | Gravity.TOP;

        layoutParams.x = 100;
        layoutParams.y = 300;

        getWindowManager().addView(button, layoutParams);

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int rawX = (int) event.getRawX();
                int rawY = (int) event.getRawY();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE: {
                        layoutParams.x = rawX;
                        layoutParams.y = rawY;
                        getWindowManager().updateViewLayout(button, layoutParams);
                        break;
                    }

                    default:
                        break;
                }

                return false;
            }
        });

    }


    class DownloadTask extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            progressDialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                while (true) {
                    int downloadPercent = doDownload();
                    publishProgress(downloadPercent);

                    if (downloadPercent >= 100) {
                        break;
                    }
                }
            } catch (Exception e) {
                return false;
            }

            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressDialog.setMessage("当前下载进度：" + values[0] + "%");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            progressDialog.dismiss();
            if (aBoolean) {
                Toast.makeText(MainActivity.this, "下载成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "下载失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //执行下载
    //返回下载进度
    public int doDownload() {
        return 0;
    }
}
