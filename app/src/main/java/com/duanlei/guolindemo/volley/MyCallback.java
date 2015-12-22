package com.duanlei.guolindemo.volley;

import com.android.volley.VolleyError;

import java.util.Map;

/**
 * Author: duanlei
 * <p/>
 * Date: 2015-12-18
 */

public interface MyCallback {
    void success(String request);
    void error(VolleyError error);
    Map<String, String> getParams();
}
