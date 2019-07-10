package com.ihesen.httpprocessor.net;

/**
 * Created by ihesen on 2019-07-11
 */
public interface ICallback {
    void onSuccess(String result);
    void onFailure(String error);
}
