package com.hsl.android.qianfeng.advancedcourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.hsl.android.qianfeng.advancedcourse.adapter.ExpandableListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> groupList = new ArrayList<>();
    private List<String> childList = new ArrayList<>();
    private ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
        bindAdapter();
    }

    private void bindAdapter() {

        expandableListView.setAdapter(new ExpandableListViewAdapter(groupList,childList,this));
    }

    private void initView() {

        expandableListView = (ExpandableListView) findViewById(R.id.el_lv);
    }

    private void initData() {

        groupList.add("山西");
        groupList.add("山西");
        childList.add("临汾");
        childList.add("临汾");
        groupList.add("山西");
        groupList.add("山西");
        childList.add("临汾");
        childList.add("临汾");


        groupList.add("湖北");
        groupList.add("湖北");
        childList.add("武汉");
        childList.add("武汉");


        groupList.add("河南");
        groupList.add("河南");
        childList.add("郑州");
        childList.add("郑州");

    }
}
