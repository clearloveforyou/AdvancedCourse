package com.hsl.android.qianfeng.advancedcourse;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * VideoView的使用
 */
public class VideoViewActivity extends AppCompatActivity {

    private VideoView videoView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        videoView = (VideoView) findViewById(R.id.video_view);
        btn = (Button) findViewById(R.id.btn_play);

        //VideoView的控制面板
        MediaController mediaController = new MediaController(this);
        //将控制面板添加到Videoview中
        videoView.setMediaController(mediaController);
        //设置视频的数据链接源
        Uri uri = Uri.parse(Config.URL);
        //将URL赋值给VideoView
        videoView.setVideoURI(uri);
        //播放
        videoView.start();
        //控制播放开始结束
        listener();
    }

    private void listener() {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()){
                    videoView.pause();
                } else {
                    videoView.start();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
