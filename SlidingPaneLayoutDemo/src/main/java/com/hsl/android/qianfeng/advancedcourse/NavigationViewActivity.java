package com.hsl.android.qianfeng.advancedcourse;

import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialmenu.MaterialMenuDrawable;

/**
 * SlidingPaneLayout结合NavigationView使用:
 * 1.NavigationView属于android design包下，所以添加依赖
 * 2.创建menu资源布局，头部布局xml,通过NavigationView的app属性应用（menu内容详见代码）
 *
 */
public class NavigationViewActivity extends AppCompatActivity {

    Toolbar toolbar;
    SlidingPaneLayout slidingPaneLayout;
    NavigationView navigationView;
    TextView txt;
    ImageView imgLogin;
    private View view;
    private boolean isDrawerOpened;
    private MaterialMenuDrawable materialMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);

        initView();
        //显示toolbar
        setSupportActionBar(toolbar);
        //增加箭头图标
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //增加侧滑栏头部布局
        navigationView.addHeaderView(view);
        //图标的变换效果
        setMaterialMenu();

        listener();
    }

    /**
     * SlidingPaneLayout结合MaterialMenu使用,实现图标变换
     *
     * 1，添加依赖：compile 'com.balysv.materialmenu:material-menu-toolbar:1.+'
     * 2.按照下面步骤使用1--4
     */
    private void setMaterialMenu() {

        //1.创建MaterialMenu图标
        materialMenu = new MaterialMenuDrawable(this, Color.BLACK, MaterialMenuDrawable.Stroke.THIN);
        //2.替换ToolBar的图标
        toolbar.setNavigationIcon(materialMenu);
        //3.设置ToolBar图标的点击事件

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle your drawable state here
                if (isDrawerOpened) {
                    slidingPaneLayout.closePane();
                } else {
                    slidingPaneLayout.openPane();
                }
            }
        });
        //4.设置SlidingPaneLayout滑动事件，从而改变MaterialMenu的效果

        slidingPaneLayout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                materialMenu.setTransformationOffset(
                        MaterialMenuDrawable.AnimationState.BURGER_ARROW,
                        isDrawerOpened ? 2 - slideOffset : slideOffset
                );
            }

            @Override
            public void onPanelOpened(View panel) {
                isDrawerOpened = true;
            }

            @Override
            public void onPanelClosed(View panel) {
                isDrawerOpened = false;
            }
        });
    }



    private void listener() {

        imgLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationViewActivity.this, "点击有效", Toast.LENGTH_SHORT).show();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.main_menu_basketball:
                        Toast.makeText(NavigationViewActivity.this, "basketball", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.group1_test1:
                        Toast.makeText(NavigationViewActivity.this, "test1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.txt:
                        Toast.makeText(NavigationViewActivity.this, "denglu", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }

    private void initView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.sliding_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        txt = (TextView) findViewById(R.id.txt_content2);
        view = LayoutInflater.from(this).inflate(R.layout.menu_header, null);
        imgLogin = (ImageView) view.findViewById(R.id.img);
    }
}
