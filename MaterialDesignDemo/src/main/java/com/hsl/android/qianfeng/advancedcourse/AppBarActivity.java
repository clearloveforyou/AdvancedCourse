package com.hsl.android.qianfeng.advancedcourse;

import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

public class AppBarActivity extends AppCompatActivity {


    private Toolbar mToolBar;
    private AppBarLayout appBarLayout;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar);

        mToolBar = (Toolbar) findViewById(R.id.toolbar_appbar);
        //添加toolbar
        setSupportActionBar(mToolBar);

        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        img = (ImageView) findViewById(R.id.img_ic3);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            /**
             * 垂直滚动的偏移量
             * @param appBarLayout
             * @param verticalOffset 偏移量。
             */
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                Toast.makeText(AppBarActivity.this, ""+verticalOffset, Toast.LENGTH_SHORT).show();

                img.setY(600+verticalOffset);
                img.setX(600+verticalOffset);
            }
        });
    }
}
