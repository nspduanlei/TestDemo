package com.duanlei.guolindemo.volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.duanlei.guolindemo.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: duanlei
 * Date: 2015-12-18
 */
public class VolleyTest {

    private static final String TAG = "VolleyTest";
    private Context mContext;

    private RequestQueue mQueue;

    public VolleyTest(Context context) {
        mContext = context;

        //RequestQueue请求队列对象，它可以缓存所有的Http请求，然后
        //按照一定的算法并发地发出这些请求
        //基本上在每一个需要和网络交互的Activity中创建一个RequestQueue对象
        //就足够了
        mQueue = Volley.newRequestQueue(context);
    }

    /**
     * get请求
     */
    public void getTest() {
        StringRequest stringRequest = new StringRequest("http://www.baidu.com",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                    }
                }
        );

        mQueue.add(stringRequest);
    }


    /**
     * post请求测试
     */
    public void postTest() {

        MyStringRequest myStringRequest = new MyStringRequest(
                Request.Method.POST,
                UrlConstant.ENDPOINT_NEW,
                new MyCallback() {
                    @Override
                    public void success(String response) {
                        Log.d(TAG, response);
                    }

                    @Override
                    public void error(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                    }

                    @Override
                    public Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("key", UrlConstant.API_KEY);
                        params.put("returntype", "json");
                        params.put("p", "1");
                        params.put("cid", "15");
                        return params;
                    }
                });

        mQueue.add(myStringRequest);

    }

    /**
     * 图片加载
     */
    private void imageRequestTest(final ImageView imageView) {

        //ImageRequest的构造函数接收六个参数，第一个参数就是图片的url
        //第二个参数是图片请求成功的回调，这里把返回的Bitmap参数设置到ImageView中
        //第三四个参数分别用于指定允许图片最大的宽度和高度，如果指定了
        ImageRequest imageRequest = new ImageRequest(
                "http://developer.android.com/images/home/aw_dac.png",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        //把返回的Bitmap参数设置到ImageView中
                        imageView.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //请求失败时显示一张默认图片
                        imageView.setImageResource(R.mipmap.icon1);
                    }
                }
        );

        mQueue.add(imageRequest);
    }

    /**
     * ImageLoader明显比 ImageLoader明显比ImageRequest更加高效，
     * 因为它不仅可以帮助我们对图片进行缓存，还可以过滤掉重复的链接
     * 避免重复发送请求
     */
    private void imageLoaderTest(ImageView imageView) {
        ImageLoader imageLoader = new ImageLoader(mQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(imageView,
                R.mipmap.icon1, R.mipmap.icon1);


        imageLoader.get("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg", listener);

    }

    private void networkImageViewTest(NetworkImageView networkImageView, ImageLoader imageLoader) {
        networkImageView.setDefaultImageResId(R.mipmap.icon1);
        networkImageView.setErrorImageResId(R.mipmap.icon1);
        networkImageView.setImageUrl(
                "http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg",
                imageLoader);
    }


}
