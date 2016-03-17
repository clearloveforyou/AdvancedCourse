package com.hsl.android.qianfeng.advancedcourse.bean;

/**
 * Created by clearlove on 2016/2/27.
 */
public class DataEntity {


    /**
     * id : 6004
     * title : “蒙顶山茶”品牌价值位居四川茶叶第一
     * source : 买买茶
     * description : 记者日前从省农业厅获悉，近日，全国农产品区域公用品牌建设研讨会在浙江杭州举行，来自西湖龙井、蒙顶山茶等全国四十多家农产品
     * wap_thumb : http://s1.sns.maimaicha.com/images/2013/06/13/20130613105727_87507_suolue3.jpg
     * create_time : 06月13日10:58
     * nickname : 抹搽人生
     */

    private String id;
    private String title;
    private String source;
    private String description;
    private String wap_thumb;
    private String create_time;
    private String nickname;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWap_thumb(String wap_thumb) {
        this.wap_thumb = wap_thumb;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }

    public String getWap_thumb() {
        return wap_thumb;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getNickname() {
        return nickname;
    }
}
