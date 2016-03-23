package com.hsl.android.qianfeng.advancedcourse;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;

public class FullScreenVideoViewActivity extends AppCompatActivity {

    private CustomVideoView customVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_video_view);

        customVideoView = (CustomVideoView) findViewById(R.id.custom_video_view);

        //VideoView的控制面板
        MediaController mediaController = new MediaController(this);
        //将控制面板添加到Videoview中
        customVideoView.setMediaController(mediaController);
        //设置视频的数据链接源
        Uri uri = Uri.parse(Config.URL);
        //将URL赋值给VideoView
        customVideoView.setVideoURI(uri);
        //播放
        customVideoView.start();
    }
}
