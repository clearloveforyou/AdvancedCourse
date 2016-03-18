package com.hsl.android.qianfeng.advancedcourse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by clearlove on 2016/3/18.
 *
 * SurfaceView的应用场景：
 * >可以在主线程之外的线程中向屏幕绘图。
 * >这样可以避免画图任务繁重的时候造成主线程阻塞，从而提高了程序的反应速度。
 * >当界面的动画元素较多，而且很多都需要通过定时器来控制这些动画元素的移动，就考虑使用SurfaceView。
 * >游戏开发中多用到SurfaceView，游戏中的背景、人物、动画等等尽量在画布canvas中画出
 *
 * SurfaceView的特点：
 *  A.具有独立的绘图表面；
 *  B.需要在宿主窗口上挖一个洞来显示自己；
 *  C.它的UI绘制可以在独立的线程中进行，这样就可以进行复杂的UI绘制，并且不会影响应用程序的主线程响应用户输入。
 *
 * SurfaceView的使用：
 * 1.创建一个类继承SurfaceView
 * 2.同时实现接口SurfaceHolder.CallBack
 * 3.重写其中的方法
 * 4.获取holder对象，（绘图助手）
 * 5.将第2步中的这个灰调接口配置到holder对象中，用于接收Holder对象提交的画面
 * 6.开启一个线程，开始绘图
 *   >1.首先锁定画布，并且返回画布对象lockCanvas
 *   >2.创建画笔，在canvas绘制内容
 *   >3.将绘制完成的图像提交到SurfaceView的主线程中显示 unLockCanvasAndPost
 * 7.在surfaceDestroyed方法中将线程停止
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /**
     * 绘图助手，可以执行在非主线程
     */
    private SurfaceHolder holder;
    private boolean isStart;

    public MySurfaceView(Context context) {
        this(context, null);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        holder = getHolder();
        //设置holder的回调接口，用于将工作线程中绘制好的画面发回主线程，显示到屏幕上
        //this: surfaceHolder.callback对象
        holder.addCallback(this);
    }

    /**
     * 创建绘图表面n
     *
     * @param holder
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        //启动画图
        isStart = true;
        new CanvasThread(holder).start();
    }

    /**
     * 当SurfaceView 的窗口大小发生变化时，回调此方法（如：横竖屏切换）
     *
     * @param holder
     * @param format
     * @param width
     * @param height
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    /**
     * 当SurfaceView销毁时，回调此方法（如：退出当前界面）
     *
     * @param holder
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        isStart = false;
    }


    /**
     * 创建一个线程，完成绘图
     */
    class CanvasThread extends Thread{

        //画笔
        private Paint mPaint;
        private SurfaceHolder surfaceHolder;
        private int i;

        public CanvasThread(SurfaceHolder surfaceHolder){
            this.mPaint = new Paint();
            this.surfaceHolder = surfaceHolder;
            mPaint.setColor(Color.GREEN);
        }
        @Override
        public void run() {


            while (isStart){

                //1.锁定Canvas画布,并可以获得被锁定的画布对象
                Canvas canvas = surfaceHolder.lockCanvas();
                mPaint.setStyle(Paint.Style.STROKE);
                //2.绘制图像
                canvas.drawCircle(400, 400, 100 * (i % 2 + 1), mPaint);
                //3.将绘制好的图像画布解锁，并提交到UI线程中显示
                holder.unlockCanvasAndPost(canvas);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }

        }
    }
}
