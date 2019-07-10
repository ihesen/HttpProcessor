package com.ihesen.httpprocessor.net;

import java.util.Map;

/**
 * Created by ihesen on 2019-07-11
 */
public interface IHttpProcessor {

    void post(String url, Map<String, Object> params, ICallback callback);

    void get(String url, Map<String, Object> params, ICallback callback);

}
