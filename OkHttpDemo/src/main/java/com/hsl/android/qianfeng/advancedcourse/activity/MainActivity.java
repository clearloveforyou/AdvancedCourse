package com.hsl.android.qianfeng.advancedcourse.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hsl.android.qianfeng.advancedcourse.R;
import com.hsl.android.qianfeng.advancedcourse.bean.AppEntity;
import com.hsl.android.qianfeng.advancedcourse.constant.TestUrl;
import com.hsl.android.qianfeng.advancedcourse.utils.LogTool;
import com.hsl.android.qianfeng.advancedcourse.utils.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //测试
        testOkHttp();
    }

    private void testOkHttp() {

        //get请求
        getOkHttp();
        LogTool.LOG_D(MainActivity.class,"--->1");
        //post请求
        postOkHttp();



    }

    private void postOkHttp() {

        OkHttpUtils.getInstance().okPost(TestUrl.FRUIT_URL, getMapParam(), AppEntity.class, new OkHttpUtils.IOkCallBack() {
            @Override
            public void onSuccess(Object resultInfo) {

            }
        });
    }

    private void getOkHttp() {
        LogTool.LOG_D(MainActivity.class,"--->2");
        OkHttpUtils.getInstance().okGet(TestUrl.TEA_URL, AppEntity.class, new OkHttpUtils.IOkCallBack<AppEntity>() {
            @Override
            public void onSuccess(AppEntity resultInfo) {

                TextView txtTest = (TextView) findViewById(R.id.txt_text);
                txtTest.setText(resultInfo.getData().get(0).getContent());
            }
        });
    }


    private Map<String,String> getMapParam(){


        Map<String,String> map = new HashMap<>();
        map.put("sign","2d691db482de1b8f61dadd7a4cad75a4");
        map.put("timestamp","1456991327");
        map.put("platform","ANDROID");
        map.put("source","app");
        map.put("connect_id","");
        map.put("region_id","106092");
        map.put("service","marketing.banner");
        map.put("device_id","dc0f477dc343e9204ad3cb8634158453");
        map.put("channel","baidu");
        map.put("version","3.3.0");

        return map;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消请求
        OkHttpUtils.getInstance().cancel();
    }
}
