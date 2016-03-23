package com.hsl.android.qianfeng.advancedcourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.hsl.android.qianfeng.advancedcourse.adapter.MyAdapter;
import com.hsl.android.qianfeng.advancedcourse.bean.DataEntitys;
import com.hsl.android.qianfeng.advancedcourse.bean.TestEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ListViewVideoActivity extends AppCompatActivity {

    private ListView lvVideo;
    private List<DataEntitys> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_video);

        lvVideo  = (ListView) findViewById(R.id.lv_video);
        //绑定适配器
        bindAdapter();
        //解析数据
        loadData();


    }

    private void bindAdapter() {

        myAdapter = new MyAdapter(list,this);
        lvVideo.setAdapter(myAdapter);
    }

    private void loadData() {
        InputStream open = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        String s = null;
        try {
            open = getAssets().open("video1.json");
            int len = 0;
            byte[] b = new byte[1024];
            byteArrayOutputStream = new ByteArrayOutputStream();
            while ((len = open.read(b)) != -1){
                byteArrayOutputStream.write(b,0,len);
                byteArrayOutputStream.flush();
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();

            s = new String(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                open.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        Gson gson = new Gson();
        TestEntity testEntity = gson.fromJson(s, TestEntity.class);
        list.addAll(testEntity.getData().getData());

        myAdapter.notifyDataSetChanged();
    }
}
