package com.ihesen.httpprocessor.net;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ihesen on 2019-07-11
 */
public class HttpHelper implements IHttpProcessor {

    private static IHttpProcessor httpProcessor = null;
    private Map<String, Object> params;

    private static HttpHelper httpHelper;

    private HttpHelper() {
        params = new HashMap<>();
    }


    public static HttpHelper getInstance() {

        synchronized (HttpHelper.class) {
            if (httpHelper == null) {
                httpHelper = new HttpHelper();
            }
        }
        return httpHelper;
    }


    public static void init(IHttpProcessor iHttpProcessor) {
        httpProcessor = iHttpProcessor;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallback callback) {
        httpProcessor.post(url, params, callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        httpProcessor.get(url, params, callback);
    }
}
