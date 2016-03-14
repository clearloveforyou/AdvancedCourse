package com.hsl.android.qianfeng.advancedcourse.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by clearlove on 2016/3/14.
 */
public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;
    List<String> titleList;
    public MyFragmentPageAdapter(FragmentManager fm,List<Fragment> fragmentList,List<String> titleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList != null?fragmentList.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
