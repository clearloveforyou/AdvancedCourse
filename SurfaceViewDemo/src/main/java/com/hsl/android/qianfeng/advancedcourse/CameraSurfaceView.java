package com.hsl.android.qianfeng.advancedcourse;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by clearlove on 2016/3/18.
 * <p/>
 * 1.添加使用照相机的权限
 * >获取surfaceholder对象，并且设置回调方法
 * 2.开启摄像头
 * 3.将摄像头的预览图片显示到surfaceview中
 */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {


    private Camera camera;

    public CameraSurfaceView(Context context) {
        this(context, null);
    }

    public CameraSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //获取holder,并设置回调(这样设置，CallBack中的三个接口方法才会执行)
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        camera = Camera.open(0);
        try {
            //
            camera.setPreviewDisplay(holder);
            //
            camera.startPreview();
            //
            camera.setDisplayOrientation(90);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        //
        camera.stopPreview();

        camera.release();
    }
}
