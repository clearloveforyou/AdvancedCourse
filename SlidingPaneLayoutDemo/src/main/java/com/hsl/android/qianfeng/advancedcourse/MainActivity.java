package com.hsl.android.qianfeng.advancedcourse;

import android.content.Intent;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * SlidingPaneLayout的使用：
 *
 * 1.(最简单的使用方式，在xml文件中用SlidingPaneLayout之间包裹两个布局
 * 即可，第一个布局显示的是侧滑的内容，第二个布局显示的正文内容)
    如：放两个FrameLayout,就可以用Fragment
    注意：第一个布局宽设定具体指最好，高度match_parent
         第二个宽高均为match_parent
        设为自适应，将没有效果
 */
public class MainActivity extends AppCompatActivity {

    private SlidingPaneLayout slidingPaneLayout;
    private TextView txt_menu;
    private Button btnChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.sliding);
        txt_menu = (TextView) findViewById(R.id.txt_menu);
        btnChange = (Button) findViewById(R.id.btn_change);
        //设置监听
        listener();
    }

    private void listener() {

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NavigationViewActivity.class);
                startActivity(intent);
            }
        });

        slidingPaneLayout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {

            //滑动中执行此方法
            //slideOffset表示滑动的偏移量
            //panel:内容界面的视图
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

                //淡入淡出效果
                txt_menu.setAlpha(slideOffset);
//                slidingPaneLayout.setAlpha(slideOffset);
//                panel.setAlpha(slideOffset);
//                slidingPaneLayout.setScaleX(slideOffset);
            }

            //完全打开
            @Override
            public void onPanelOpened(View panel) {

            }

            //完全关闭
            @Override
            public void onPanelClosed(View panel) {

            }
        });
    }
}
