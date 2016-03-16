package com.hsl.android.qianfeng.advancedcourse.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by clearlove on 2016/3/16.
 */
public class FastJsonUtils {

    /**
     *
     * @param s json数据
     * @param cls javabean
     * @param <T>
     * @return
     */
    public static <T> T parseJson(String s , Class<T> cls){

        return JSONObject.parseObject(s,cls);
    }
}
