package com.duanlei.guolindemo.camera;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.ImageView;

import com.duanlei.guolindemo.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Author: duanlei
 * Date: 2016-02-01
 */
public class Result extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        String picPath = getIntent().getExtras().getString("picPath");

        if (picPath == null) {
            return;
        }

        ImageView imageView = (ImageView) findViewById(R.id.iv_result);

        try {
            FileInputStream fis = new FileInputStream(picPath);

            Bitmap bitmap = BitmapFactory.decodeStream(fis);

            Matrix matrix = new Matrix();
            matrix.setRotate(90);

            bitmap = Bitmap.createBitmap(bitmap, 0, 0,
                    bitmap.getWidth(), bitmap.getHeight(), matrix, true);


            imageView.setImageBitmap(bitmap);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        Bitmap bitmap = BitmapFactory.decodeFile(picPath);
//        imageView.setImageBitmap(bitmap);


    }
}
