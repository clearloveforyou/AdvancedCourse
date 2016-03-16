package com.hsl.android.qianfeng.advancedcourse.utils;

import android.os.Handler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by clearlove on 2016/3/16.
 * OkHttp的使用：
 * 1.添加依赖：compile 'com.squareup.okhttp3:okhttp:3.2.0'
 * 2.初始化OkHttpClient；官方建议OkHttpClient在一个APP中只实例化一次。
 * 3.get请求：
 * >1.创建一个Request
 * >2.创建Call任务 ：Call call = mOkHttpClient.newCall(request)
 * >3.将请求加入调度 :
 * >1.同步:call.execute()
 * >2.异步：call.enqueue()
 * >4.取消请求：在生命周期的onstop调用call.cancel()
 */
public class OkHttpUtils {

    /**
     * 创建单例
     * 官方建议OkHttpClient在一个APP中只实例化一次
     */
    private static OkHttpClient okHttpClient;

    static {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient();
        }
    }

    private static Handler mHandler = new Handler();

    /**
     * get请求
     * @param url
     * @param cls
     * @param okCallBack
     * @param <T>
     */
    public static <T> void okGet(String url, final Class<T> cls, final IOkCallBack okCallBack) {

        LogTool.LOG_D(OkHttpUtils.class,"--->4=" + url);
        //1.创建请求
        Request request = new Request.Builder()
                .url(url)
                .build();
        //2.创建Call任务
        Call call = okHttpClient.newCall(request);
        //3.异步请求
        call.enqueue(new Callback() {

            //请求失败
            @Override
            public void onFailure(Call call, IOException e) {

                LogTool.LOG_D(OkHttpUtils.class,"--->5");
                //执行在工作线程中，不能更新ui
                LogTool.LOG_D(OkHttpUtils.class, "--2------>数据求情失败");

            }

            //请求成功
            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                LogTool.LOG_D(OkHttpUtils.class,"--->6");
                //执行在工作线程中，不能更新ui

                //一般情况下，比如我们希望获得返回的字符串，可以通过response.body().string()获取,只能取一次,如果使用相同语句重复获取，为空；
                //如果希望获得返回的二进制字节数组，则调用response.body().bytes()；
                //如果你想拿到返回的inputStream，则调用response.body().byteStream()

                final String jsonStr = response.body().string();
                LogTool.LOG_D(OkHttpUtils.class, "-------->数据求情成功"+jsonStr);
                //解析
                final T t = GsonUtils.parseJson2Object(jsonStr, cls);

                /**
                 * 说明：
                 * 一般来说在工作线程中执行耗时任务，当任务完成时，会返回UI线程，一般是更新UI。这时有两种方法可以达到目的。
                 *一种是handler.sendMessage。发一个消息，再根据消息，执行相关任务代码。
                 *另一种是handler.post(r)。
                 *r是要执行的任务代码。
                 *意思就是说r的代码实际是在UI线程执行的。可以写更新UI的代码。（工作线程是不能更新UI的）
                 */
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        okCallBack.onSuccess(t);
                    }
                });
            }
        });
    }

    /**
     *
     * @param url URL
     * @param param 请求参数
     * @param cls bean最外层
     * @param iOkCallBack 回调接口
     * @param <T>
     */
    public static <T> void okPost(String url,Map<String,String> param, final Class<T> cls, final IOkCallBack iOkCallBack) {

        //application/json是Http协议中的ContentType，charset=utf-8是Http协议中的编码格式
        //制定参数的编码方式和参数的格式
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        //设置POST的请求入参
        String formatParam = formatParam(param);
        RequestBody requestBody = RequestBody.create(mediaType, formatParam);
        //1.创建请求
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        //2.创建Call任务
        Call call = okHttpClient.newCall(request);
        //3.异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final T t = GsonUtils.parseJson2Object(response.body().string(), cls);
                LogTool.LOG_D(OkHttpUtils.class, "-------->数据求情成功"+t.toString());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iOkCallBack.onSuccess(t);
                    }
                });
            }
        });


    }

    /**
     *
     * @param param post请求参数
     * @return
     */
    private static String formatParam(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        try {
            Set<String> keySet = param.keySet();
            for (String key : keySet) {
                jsonObject.put(key, param.get(key));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();

    }

    /**
     * 内部接口
     * @param <E>
     */
    public interface IOkCallBack<E> {

        public void onSuccess(E resultInfo);
    }
}