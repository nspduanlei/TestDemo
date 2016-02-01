package com.duanlei.guolindemo.camera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.duanlei.guolindemo.R;

/**
 * Author: duanlei
 * Date: 2016-02-01
 */
public class TestCamera extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_camera);

    }

    public void startCamera(View view){
        //使用隐式intent启用另外一个应用

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);

    }
}
