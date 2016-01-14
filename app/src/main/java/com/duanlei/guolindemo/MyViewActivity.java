package com.duanlei.guolindemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Author: duanlei
 * Date: 2015-11-30
 */
public class MyViewActivity extends Activity {

//    Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 1:
//                    Toast.makeText(MyViewActivity.this, "test", Toast.LENGTH_SHORT).show();
//                    break;
//            }
//        }
//    };
//
//    WeakReference<Handler> weakRef = new WeakReference<>(mHandler);

    //private static Context sContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myview_2);

        //sContext = this;

//        TopBar topBar = (TopBar) findViewById(R.id.topbar);
//        topBar.setOnTopbarClickListener(new TopBar.TopbarClickLister() {
//            @Override
//            public void leftClick() {
//                Toast.makeText(MyViewActivity.this, "left", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void rightClick() {
//                Toast.makeText(MyViewActivity.this, "right", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        MyProgress myProgress = (MyProgress) findViewById(R.id.myProgress);
//        myProgress.setSweepAngle(180);

        //mHandler = null;
    }

//    public void test(View view) {
//        thread.start();
//
//    }

//
//    Thread thread = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            weakRef.get().obtainMessage(1).sendToTarget();
//        }
//    });



}
