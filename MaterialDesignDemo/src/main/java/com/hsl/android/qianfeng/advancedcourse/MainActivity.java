package com.hsl.android.qianfeng.advancedcourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lvDemo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDemo = (ListView) findViewById(R.id.lv_main);

        lvDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                switch (position) {
                    case 0:
                        intent.setClass(MainActivity.this,CoordinatorActivity.class);
                        break;
                    case 1:
                        intent.setClass(MainActivity.this,AppBarActivity.class);
                        break;
                    case 2:
                        intent.setClass(MainActivity.this,CollapsingToolBarActivity.class);
                        break;
                    case 3:
                        intent.setClass(MainActivity.this,BehaviorActivity.class);
                        break;
                    case 4:
                        intent.setClass(MainActivity.this,SnackActivity.class);
                        break;
                    case 5:
                        intent.setClass(MainActivity.this,FloatingActionButtonActivity.class);
                        break;

                }

                startActivity(intent);
            }
        });
    }
}
