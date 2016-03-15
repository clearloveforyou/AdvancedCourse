package com.hsl.android.qianfeng.advancedcourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * butterknife的使用：
 * 1.添加依赖：compile 'com.jakewharton:butterknife:7.0.1'
 * 2.进行注入
 *
 */

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注入
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1,R.id.btn2})
    public void onClick(View view){

        switch (view.getId()){
            case R.id.btn1:
                Toast.makeText(MainActivity.this, "btn1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(MainActivity.this, "btn2", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
