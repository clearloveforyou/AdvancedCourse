package com.hsl.android.qianfeng.advancedcourse.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsl.android.qianfeng.advancedcourse.R;
import com.hsl.android.qianfeng.advancedcourse.bean.DataEntity;
import com.hsl.android.qianfeng.advancedcourse.utils.LogTool;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by clearlove on 2016/3/16.
 */



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.VH> {

    private List<DataEntity> list;
    private LayoutInflater inflater;
    private Context context;
    public RecyclerViewAdapter(List<DataEntity> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    /**
     * 创建ViewHolder对象,并且对Item的布局进行初始化
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_aapter,null);
        VH vh = new VH(view);
        return vh;
    }

    /**
     * 此方法是给Item布局中的控件赋值
     *
     * @param holder   onCreateViewHolder方法返回的ViewHolder对象
     * @param position Item的索引
     */
    @Override
    public void onBindViewHolder(final VH holder, final int position) {

        holder.txtItemTitle.setText(list.get(position).getNickname());
        holder.txtItemTime.setText(list.get(position).getCreate_time());
        holder.txtItemDesc.setText(list.get(position).getDescription());

        /**
         * 图片加载使用Picasso
         * github上添加yilai
         * url要进行为空判断
         *
         */

        //设置Debug方查看图片是从内存或者磁盘或者网络上加载下来的
        Picasso.with(context).setIndicatorsEnabled(true);
        String wap_thumb = list.get(position).getWap_thumb();

        if (wap_thumb != null && !"".equals(wap_thumb)){
            Picasso.with(context)
                    .load(wap_thumb)
//                    //设置图片加载过程默认显示的图片
//                    .placeholder(R.mipmap.no_ufo)
//                    //设置图片加载失败时显示的图片
//                    .error(R.mipmap.ic_launcher)
                    .into(holder.imgItemTitle);
        }

        //设置监听事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回调接口
                mOnItemClickLitener.onItemClick(holder.itemView,position);
            }
        });

    }

    /**
     * 返回Item的个数---也数据数据源的大小
     *
     * @return
     */
    @Override
    public int getItemCount() {

        return list != null ? list.size() : 0;

    }

    /**
     * 创建viewholder
     */
    public class VH extends RecyclerView.ViewHolder {

        @Bind(R.id.img_item_title)
        ImageView imgItemTitle;
        @Bind(R.id.txt_item_title)
        TextView txtItemTitle;
        @Bind(R.id.txt_item_time)
        TextView txtItemTime;
        @Bind(R.id.txt_item_desc)
        TextView txtItemDesc;

        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    /**
     * 实现监听
     */
    public interface OnItemClickListener{

        public abstract void onItemClick(View view,int position);
    }

    private  OnItemClickListener mOnItemClickLitener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
}
