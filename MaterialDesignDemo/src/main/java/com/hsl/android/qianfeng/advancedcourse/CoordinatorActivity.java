package com.hsl.android.qianfeng.advancedcourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * CoordinatorLayout使用：
 *
 *    1、作为顶层布局
 *    2、调度协调子布局
 *    3.使用CoordinatorLayout需要在Gradle加入Support Design Library：
 *      compile 'com.android.support:design:24.0.0-alpha1'
 *    4.关键属性：
 *           //锚点位置
 *           app:layout_anchor="@id/button2"
             app:layout_anchorGravity="right"
      5.参考布局文件
 *
 */
public class CoordinatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
    }
}
