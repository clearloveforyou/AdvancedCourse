package com.hsl.android.qianfeng.advancedcourse.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsl.android.qianfeng.advancedcourse.R;
import com.hsl.android.qianfeng.advancedcourse.bean.DataEntitys;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

/**
 * Created by clearlove on 2016/3/23.
 */
public class MyAdapter extends BaseAdapter {

    private List<DataEntitys> list;
    private LayoutInflater inflater;
    private Context context;
    MediaPlayer mediaPlayer;
    int videoPlayingPosition;

    public MyAdapter(List<DataEntitys> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public int getCount() {

        return list != null ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null){

            convertView = inflater.inflate(R.layout.video_adapter,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        DataEntitys.GroupEntity group = list.get(position).getGroup();
        //动态设置SurfaceView的高度和宽度

//        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewHolder.surfaceView.getLayoutParams();
//        if (group != null && group.getValue360p_video() != null) {
//            layoutParams.width = group.getValue360p_video().getWidth();
//            layoutParams.height = group.getValue360p_video().getHeight();
//            viewHolder.surfaceView.setLayoutParams(layoutParams);
//            viewHolder.img.setLayoutParams(layoutParams);
//            viewHolder.surfaceView.requestLayout();//请求重新执行onMeasure方法和onLayout方法、onDraw（请求重新绘制）
//        }

        Object tag = viewHolder.img.getTag();
        if (tag != null) {
            Integer integer = Integer.valueOf(tag.toString());
            //integer != position此判断表示被回收的Item再次被利用
            //videoPlayingPosition == integer表示此Item上的视频正在播放
            if (integer != position && videoPlayingPosition == integer){
                mediaPlayer.stop();
                viewHolder.img.setVisibility(View.VISIBLE);
                viewHolder.surfaceView.setVisibility(View.GONE);
            }
        }

        if (group != null){

            viewHolder.txtTitle.setText(group.getTitle());
            viewHolder.txtContent.setText(group.getText());
        }

        if (group != null && group.getLarge_cover() != null
                && group.getLarge_cover().getUrl_list() != null
                && !group.getLarge_cover().getUrl_list().isEmpty()
                && group.getLarge_cover().getUrl_list().get(0) != null){
            String url = group.getLarge_cover().getUrl_list().get(0).getUrl();
            Picasso.with(context)
                    .load(url)
                    .error(R.mipmap.ic_launcher)
                    .into(viewHolder.img);
        }


        viewHolder.img.setTag(position);
        return convertView;
    }

     class ViewHolder implements View.OnClickListener,MediaPlayer.OnPreparedListener{

        public TextView txtTitle;
        public TextView txtContent;
        public ImageView img;
        public SurfaceView surfaceView;
        public ViewHolder(View view){

            txtTitle = (TextView) view.findViewById(R.id.txt_tilte);
            txtContent = (TextView) view.findViewById(R.id.txt_content);
            img = (ImageView) view.findViewById(R.id.img_video);
            surfaceView = (SurfaceView) view.findViewById(R.id.test_surface_view);
            //设置监听
            img.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            v.setVisibility(View.INVISIBLE);
            surfaceView.setVisibility(View.VISIBLE);
            int position = Integer.parseInt(v.getTag().toString());
            videoPlayingPosition = position;
            DataEntitys.GroupEntity group = list.get(position).getGroup();
            if (group != null){
                String mp4_url = group.getMp4_url();
                //重置，恢复初始状态
                mediaPlayer.reset();
                Uri uri = Uri.parse(mp4_url);
                try {
                    mediaPlayer.setDataSource(context,uri);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            mediaPlayer.setDisplay(surfaceView.getHolder());
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(this);

        }

         @Override
         public void onPrepared(MediaPlayer mp) {
             //准备工作完成开始播放视频
             mediaPlayer.start();
         }
     }
}
