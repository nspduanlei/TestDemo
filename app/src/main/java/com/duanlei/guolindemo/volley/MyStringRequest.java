package com.duanlei.guolindemo.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Author: duanlei
 * Date: 2015-12-18
 */
public class MyStringRequest extends StringRequest {

    private MyCallback mMyCallback;

    public MyStringRequest(String url, final MyCallback myCallback) {
        super(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        myCallback.success(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        myCallback.error(error);
                    }
                });

        mMyCallback = myCallback;
    }

    public MyStringRequest(int method, String url, final MyCallback myCallback) {
        super(method, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        myCallback.success(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        myCallback.error(error);
                    }
                });

        mMyCallback = myCallback;
    }


    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mMyCallback.getParams();
    }
}
