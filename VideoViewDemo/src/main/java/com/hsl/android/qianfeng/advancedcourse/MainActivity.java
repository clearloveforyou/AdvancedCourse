package com.hsl.android.qianfeng.advancedcourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private ListView lvMian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMian = (ListView) findViewById(R.id.lv_main);

        lvMian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                switch (position){

                    case 0:
                        intent.setClass(MainActivity.this,VideoViewActivity.class);
                        break;
                    case 1:
                        intent.setClass(MainActivity.this,FullScreenVideoViewActivity.class);
                        break;
                    case 2:
                        intent.setClass(MainActivity.this,SurfaceViewMediaActivity.class);
                        break;
                    case 3:
                        intent.setClass(MainActivity.this,ListViewVideoActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }
}
