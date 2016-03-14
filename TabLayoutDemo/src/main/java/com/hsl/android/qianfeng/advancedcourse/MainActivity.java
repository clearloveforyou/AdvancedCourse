package com.hsl.android.qianfeng.advancedcourse;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hsl.android.qianfeng.advancedcourse.adapter.MyFragmentPageAdapter;
import com.hsl.android.qianfeng.advancedcourse.fragment.ActivityFragment;
import com.hsl.android.qianfeng.advancedcourse.fragment.CollectionFragment;
import com.hsl.android.qianfeng.advancedcourse.fragment.GamesFragment;
import com.hsl.android.qianfeng.advancedcourse.fragment.GbaFragment;
import com.hsl.android.qianfeng.advancedcourse.fragment.HappyFragment;
import com.hsl.android.qianfeng.advancedcourse.fragment.NewFragment;
import com.hsl.android.qianfeng.advancedcourse.fragment.OfficialFragment;
import com.hsl.android.qianfeng.advancedcourse.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Tablayout与ViewPager的联动
 * 1.添加依赖：compile ‘com.android.support:design:22.2.0‘
 * <p/>
 * 2.
 * 给Viewpager设置适配器，适配器中重写getTitle方法
 * viewPager.setAdapter(myViewPager);
 * //将TabLayout和ViewPager关联起来。
 * tabLayout.setupWithViewPager(viewPager);
 */
public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView imgNext;
    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        //关联设配器，同时实现与tablayout的联动
        bindAdapter();
        //监听
        listener();
    }

    private void listener() {

        //点击next,实现tab向下移动
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                if (selectedTabPosition < tabLayout.getTabCount()-1) {
                    tabLayout.getTabAt(selectedTabPosition + 1).select();
                }
            }
        });

        //对tab监听
       tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               Toast.makeText(MainActivity.this, ""+tab.getText(), Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });
    }

    private void bindAdapter() {

        MyFragmentPageAdapter adapter = new MyFragmentPageAdapter(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(adapter);

        //以下属性也可在代码中设置
        //MODE_SCROLLABLE: 可滚动的;MODE_FIXED：固定不可滚动
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //设置游标指示器颜色
        tabLayout.setSelectedTabIndicatorColor(Color.RED);
        //设置文字颜色
        tabLayout.setTabTextColors(Color.BLACK, Color.BLUE);


        //将TabLayout和ViewPager关联起来
        tabLayout.setupWithViewPager(viewPager);

        //给第一个tab设置图片(只能放在关联之后，否则获取不到tab)
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
    }


    private void initData() {

        //初始化Tablayout实现的标题
        titleList.add("最新");
        titleList.add("赛事");
        titleList.add("视频");
        titleList.add("娱乐");
        titleList.add("官方");
        titleList.add("攻略");
        titleList.add("活动");
        titleList.add("收藏");
        //初始化ViewPage显示的Fragement
        fragmentList.add(NewFragment.newInstance());
        fragmentList.add(GamesFragment.newInstance());
        fragmentList.add(VideoFragment.newInstance());
        fragmentList.add(HappyFragment.newInstance());
        fragmentList.add(OfficialFragment.newInstance());
        fragmentList.add(GbaFragment.newInstance());
        fragmentList.add(ActivityFragment.newInstance());
        fragmentList.add(CollectionFragment.newInstance());

    }

    private void initView() {

        tabLayout = (TabLayout) findViewById(R.id.tablyt);
        viewPager = (ViewPager) findViewById(R.id.vp);
        imgNext = (ImageView) findViewById(R.id.image_next);
    }


}
