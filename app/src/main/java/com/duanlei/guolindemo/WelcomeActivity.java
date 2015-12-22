package com.duanlei.guolindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Author: duanlei
 * Date: 2015-11-30
 */
public class WelcomeActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        findViewById(R.id.btn_front_service).setOnClickListener(this);

        findViewById(R.id.btn_drag_view).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_front_service:
                startActivity(new Intent(this, ServiceTestActivity.class));
                break;
            case R.id.btn_drag_view:
                startActivity(new Intent(this, MyViewActivity.class));
                break;
            default:
                break;
        }

    }
}
