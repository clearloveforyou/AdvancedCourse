package com.hsl.android.qianfeng.advancedcourse;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.hsl.android.qianfeng.advancedcourse.adapter.RecyclerViewAdapter;
import com.hsl.android.qianfeng.advancedcourse.bean.DataEntity;
import com.hsl.android.qianfeng.advancedcourse.bean.TitleEntity;
import com.hsl.android.qianfeng.advancedcourse.constant.TeaUrl;
import com.hsl.android.qianfeng.advancedcourse.utils.OkHttpUtils;
import com.hsl.android.qianfeng.advancedcourse.utils.RecyclerViewHeader;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import okhttp3.FormBody;

/**
 * 控件RecyclerView的使用步骤：
 * 1.导入design包（github添加依赖（或者直接在androidstudio 中添加，搜索时小写））
 * 2.在布局文件中声明控件
 * 3.设置layoutManager
 * 4.设置Adapter
 * <p/>
 * <p/>
 * 额外添加功能：
 * 1.在适配器中添加接口，实现监听功能
 * 2.okhttp的post请求，采用表单传参数
 * 3.添加分割线
 * 4.添加头部 :直接在github上搜索RecyclerViewHeader,copy其中的文件
 * 5.刷新
 * 6.动画效果；ScaleInAnimator, ScaleInTopAnimator, ScaleInBottomAnimator
             ScaleInLeftAnimator, ScaleInRightAnimator
 *
 *          添加代码： SlideInLeftAnimationAdapter animationAdapter = new SlideInLeftAnimationAdapter(adapter);
 *                   recyclerMian.setAdapter(animationAdapter);
 */


public class MainActivity extends AppCompatActivity {


    @Bind(R.id.recycler_mian)
    RecyclerView recyclerMian;

    //页数
    private int page = 1;
    //
    private List<DataEntity> list = new ArrayList<>();
    RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //初始化数据
        initData();
        //初始化控件
        initView();
        //设置监听事件
        listener();
    }

    private void listener() {

        /**
         * RecyclerView没有实现item的监听。此处自定义监听
         *
         */

        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "你点击了第" + position + "个item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {

        //设置布局管理器
        recyclerMian.setLayoutManager(getGridLayoutManager());

        /**
         * 添加分割线
         */
        //水平分割
        recyclerMian.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(this)
                        .color(Color.RED)
                        .size(10)
                        .build());
        //垂直分割
        recyclerMian.addItemDecoration(
                new VerticalDividerItemDecoration.Builder(this)
                        .color(Color.BLUE)
                        .size(10)
                        .build());

        //添加头部
        RecyclerViewHeader header = RecyclerViewHeader.fromXml(this, R.layout.recyclerview_head);
        header.attachTo(recyclerMian);

        /**
         * 添加动画
         */
        recyclerMian.setItemAnimator(new SlideInLeftAnimator());


        //创建适配器
        adapter = new RecyclerViewAdapter(list, this);
        //设置适配器
        SlideInLeftAnimationAdapter animationAdapter = new SlideInLeftAnimationAdapter(adapter);
        recyclerMian.setAdapter(animationAdapter);
    }

    private void initData() {

        //求情网络数据
        OkHttpUtils.getInstance().okPost(TeaUrl.TEA_POST_URL, getFormBody(), TitleEntity.class, new OkHttpUtils.IOkCallBack<TitleEntity>() {
            @Override
            public void onSuccess(TitleEntity resultInfo) {

                //获取数据源
                list.addAll(resultInfo.getData());
                adapter.notifyDataSetChanged();

            }
        });
    }


    /**
     * 布局管理器
     * listview 的水平与垂直
     *
     * @return
     */
    private LinearLayoutManager getLinearLayoutManager() {

        LinearLayoutManager llm = null;

        //相当于ListView
        llm = new LinearLayoutManager(this);

//        //水平方向的ListView
//        llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//
        return llm;
    }

    /**
     * Gridview
     *
     * @return
     */
    public GridLayoutManager getGridLayoutManager() {
//        GridLayoutManager glm = new GridLayoutManager(this, 2);
        GridLayoutManager glm = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        return glm;
    }

    /**
     * 实现瀑布流,图片墙效果
     *
     * @return
     */
    public StaggeredGridLayoutManager getStaggeredGridLayoutManager() {
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        return sglm;
    }

    /**
     * FormBody：表单方式提交请求参数
     *
     * @return
     */
    private FormBody getFormBody() {
        FormBody formBody = new FormBody.Builder()
                .add("rows", "15")
                .add("page", String.valueOf(page))
                .add("type", "53")
                .build();
        return formBody;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消网络请求
        OkHttpUtils.getInstance().cancel();
    }
}
