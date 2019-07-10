package com.ihesen.httpprocessor.net;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by ihesen on 2019-07-11
 */
public abstract class HttpCallback<Result> implements ICallback {

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> clazz = generate(this);
        Result objResult = (Result) gson.fromJson(result, clazz);
        onSuccess(objResult);
    }

    protected abstract void onSuccess(Result objResult);

    private Class<?> generate(Object object) {
        Type type = object.getClass().getGenericSuperclass();
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();
        return types[0].getClass();
    }

}
