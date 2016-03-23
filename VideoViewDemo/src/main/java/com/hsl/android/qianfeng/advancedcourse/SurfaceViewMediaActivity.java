package com.hsl.android.qianfeng.advancedcourse;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.Toast;

import java.io.IOException;

/**
 * SurfaceVeiw+MediaPlayer组合的使用：
 *
 * 1.获取一个SurfaceView对象
 * 2.给SurfaceView添加CallBack方法
 * 3.创建一个MediaPlayer对象
 *
 */
public class SurfaceViewMediaActivity extends AppCompatActivity implements SurfaceHolder.Callback,MediaPlayer.OnPreparedListener {

    private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view_media);

        surfaceView = (SurfaceView) findViewById(R.id.surface_videoview);

        //通过surfaceview获取它的绘图帮助类Holder
        SurfaceHolder holder = surfaceView.getHolder();
        //设置Holder的回调监听方法
        holder.addCallback(this);
        initMedia();

//        //当视频播放异常时回调接口
//        mediaPlayer.setOnErrorListener();

        //视屏播放完毕，回调的接口
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(SurfaceViewMediaActivity.this, "播放完毕，谢谢观看", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initMedia() {

        //对媒体播放的工具类
        mediaPlayer = new MediaPlayer();
    }

    /**
     * 当holder准备好之后回调此方法
     * @param holder
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        //重置mediaPlayer对象，让其恢复到初始状态
        mediaPlayer.reset();
        //设置数据源
        Uri uri = Uri.parse(Config.URL);
        try {
            //参数一：上下文，参数二：uri对象
            mediaPlayer.setDataSource(this,uri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将mediaPlayer采集到的视频数据绘制到SurfaceView中
        //此处使用holder对象
        //也就是将surfaceview与mediapiayer关联
        mediaPlayer.setDisplay(holder);
        //准备采集视频数据(异步加载视频数据)
        //准备工作做完之后，会将准备结束的消息通过OnPreparedListener接口回调的方式进行告知
        mediaPlayer.prepareAsync();
        //
        mediaPlayer.setOnPreparedListener(this);

    }

    /**
     * surface大小发生改变时，执行
     * @param holder
     * @param format
     * @param width
     * @param height
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    /**
     * 视图销毁时，执行
     * @param holder
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        //当试图销毁时,停止播放，释放资源
        mediaPlayer.stop();
        mediaPlayer.release();

    }

    /**
     * 准备工作结束后，回调方法
     * @param mp
     */
    @Override
    public void onPrepared(MediaPlayer mp) {

        //准备视频数据结束后，开始在此处播放
        mediaPlayer.start();
    }
}
