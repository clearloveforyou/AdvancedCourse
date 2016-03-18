package com.hsl.android.qianfeng.advancedcourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {

    private ImageView imgScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imgScan = (ImageView) findViewById(R.id.iv_scan);
        //0，到 1
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f,1.0f,0f,1.0f);
        scaleAnimation.setRepeatCount(-1);//无限次数
        scaleAnimation.setRepeatMode(ScaleAnimation.RESTART);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setDuration(2000);
        imgScan.startAnimation(scaleAnimation);
    }
}
