package com.hsl.android.qianfeng.advancedcourse.utils;

import com.google.gson.Gson;

/**
 * Created by yangjw on 2016/3/16.
 */
public class GsonUtils {

    private static Gson gson = new Gson();

    /**
     * 将一个json字符串转换成Object对象
     * @param json
     * @param object
     * @param <T>
     * @return
     */
    public static <T> T parseJson2Object(String json,Class<T> object) {
        return gson.fromJson(json,object);
    }
}
