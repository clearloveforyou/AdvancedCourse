package com.hsl.taole.worksample;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;
    private List<String> titles;
    private void one(){
        //第一个版本
    }
    private int[] tabIcons = {
            R.drawable.tab1,
            R.drawable.tab2,
            R.drawable.tab3,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        tab = (TabLayout) findViewById(R.id.tabs);
        vp = (ViewPager) findViewById(R.id.vps);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getFragments(), getTitles());
        vp.setAdapter(adapter);

        tab.setTabMode(TabLayout.MODE_FIXED);

        tab.setupWithViewPager(vp);
        //添加icons
        setupTabIcons();

    }


    //创建Fragmnets
    private List<Fragment> getFragments(){

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(NewsFragment.newInstance());
        fragments.add(NBAFragment.newInstance());
        fragments.add(GiftFragment.newInstance());

        return fragments;
    }

    //获取tabs信息
    private List<String> getTitles(){

        titles = new ArrayList<>();
        titles.add("新闻");
        titles.add("NBA");
        titles.add("礼物");
        return titles;
    }

    private void setupTabIcons() {
        tab.getTabAt(0).setCustomView(getTabView(0));
        tab.getTabAt(1).setCustomView(getTabView(1));
        tab.getTabAt(2).setCustomView(getTabView(2));
    }


    public View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_tab, null);
        TextView txt_title = (TextView) view.findViewById(R.id.txt);
        txt_title.setText(titles.get(position));
        ImageView img_title = (ImageView) view.findViewById(R.id.image);
        img_title.setImageResource(tabIcons[position]);

        return view;
    }

}
