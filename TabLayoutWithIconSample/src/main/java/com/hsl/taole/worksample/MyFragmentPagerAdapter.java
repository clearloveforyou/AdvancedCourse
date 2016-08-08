package com.hsl.taole.worksample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 工程名：WorkSample
 * 包名：com.hsl.taole.worksample
 * 作者：HouShengLi
 * 时间：2016/8/8 10:21
 * 邮箱：13967189624@163.com
 * 描述：
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;

    public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragments,List<String> titles) {
        super(fm);

        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
