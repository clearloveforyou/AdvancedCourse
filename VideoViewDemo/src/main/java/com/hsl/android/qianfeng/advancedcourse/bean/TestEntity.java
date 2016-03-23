package com.hsl.android.qianfeng.advancedcourse.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by clearlove on 2016/3/23.
 */
public class TestEntity implements Serializable {


    private String message;
    private DataEntity data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        private boolean has_more;
        private String tip;
        private boolean has_new_message;
        private int max_time;
        /**
         * group : {"360p_video":{"width":202,"url_list":[{"url":"http://i.snssdk.com/neihan/video/playback/?video_id=840aebabb21d4ed7a27dfd5f993f86e3&quality=360p&line=0&is_gif=0"},{"url":"http://i.snssdk.com/neihan/video/playback/?video_id=840aebabb21d4ed7a27dfd5f993f86e3&quality=360p&line=1&is_gif=0"}],"uri":"360p/840aebabb21d4ed7a27dfd5f993f86e3","height":360},"mp4_url":"http://i.snssdk.com/neihan/video/playback/?video_id=840aebabb21d4ed7a27dfd5f993f86e3&quality=480p&line=0&is_gif=0.mp4","text":"【女子地铁上吃凤爪乱吐并侮辱周边乘客】近日，上海地铁上几名乘客在与一位穿着时髦的女子理论，众人指责其在车厢内吃泡椒凤爪并将骨头扔在地上，女子不服，并脏话连篇称\u201c你屁股上的哪只眼睛看到了？\u201d，还拿出手机与爆料者对拍。你怎么看？","720p_video":{"width":202,"url_list":[{"url":"http://i.snssdk.com/neihan/video/playback/?video_id=840aebabb21d4ed7a27dfd5f993f86e3&quality=720p&line=0&is_gif=0"},{"url":"http://i.snssdk.com/neihan/video/playback/?video_id=840aebabb21d4ed7a27dfd5f993f86e3&quality=720p&line=1&is_gif=0"}],"uri":"720p/840aebabb21d4ed7a27dfd5f993f86e3","height":360},"digg_count":4244,"duration":116.28,"480p_video":{"width":202,"url_list":[{"url":"http://i.snssdk.com/neihan/video/playback/?video_id=840aebabb21d4ed7a27dfd5f993f86e3&quality=480p&line=0&is_gif=0"},{"url":"http://i.snssdk.com/neihan/video/playback/?video_id=840aebabb21d4ed7a27dfd5f993f86e3&quality=480p&line=1&is_gif=0"}],"uri":"480p/840aebabb21d4ed7a27dfd5f993f86e3","height":360},"create_time":1451877078,"keywords":"","id":5868963711,"favorite_count":356,"go_detail_count":12808,"m3u8_url":"","large_cover":{"url_list":[{"url":"http://p1.pstatp.com/large/a000f40e3,9b5230a5"},{"url":"http://p4.pstatp.com/large/a000f40e3,9b5230a5"},{"url":"http://p4.pstatp.com/large/a000f40e3,9b5230a5"}],"uri":"large/a000f40e3,9b5230a5"},"user_favorite":0,"share_type":1,"title":"【女子地铁上吃凤爪乱吐并侮辱周边乘客】近日，上海地铁上几名乘客在与一位穿着时髦的女子理论，众人指责其在车厢内吃泡椒凤爪并将骨头扔在地上，女子不服，并脏话连篇称\u201c你屁股上的哪只眼睛看到了？\u201d，还拿出手机与爆料者对拍。你怎么看？","is_can_share":1,"category_type":1,"share_url":"http://m.neihanshequ.com/share/group/5868963711/?iid=2767929313&app=joke_essay","label":1,"content":"【女子地铁上吃凤爪乱吐并侮辱周边乘客】近日，上海地铁上几名乘客在与一位穿着时髦的女子理论，众人指责其在车厢内吃泡椒凤爪并将骨头扔在地上，女子不服，并脏话连篇称\u201c你屁股上的哪只眼睛看到了？\u201d，还拿出手机与爆料者对拍。你怎么看？","video_height":360,"comment_count":2001,"cover_image_uri":"a000f40e3,9b5230a5","media_type":3,"share_count":3397,"type":2,"status":112,"has_comments":0,"publish_time":"","user_bury":0,"status_desc":"热门投稿","dislike_reason":[{"type":2,"id":77,"title":"吧:奇葩新闻"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":3351558401,"title":"作者:柔弱坏女子"}],"play_count":242747,"user_repin":0,"medium_cover":{"url_list":[{"url":"http://p1.pstatp.com/w202/a000f40e3,9b5230a5"},{"url":"http://p4.pstatp.com/w202/a000f40e3,9b5230a5"},{"url":"http://p4.pstatp.com/w202/a000f40e3,9b5230a5"}],"uri":"medium/a000f40e3,9b5230a5"},"user":{"is_following":false,"avatar_url":"http://s0.pstatp.com/image/avatar.png","user_id":3351558401,"name":"柔弱坏女子","user_verified":false},"user_digg":0,"video_width":202,"online_time":1451877078,"category_name":"奇葩新闻","flash_url":"","category_visible":true,"bury_count":788,"is_anonymous":false,"repin_count":356,"uri":"840aebabb21d4ed7a27dfd5f993f86e3","is_public_url":1,"has_hot_comments":1,"allow_dislike":true,"origin_video":{"width":202,"url_list":[{"url":"http://i.snssdk.com/neihan/video/playback/?video_id=840aebabb21d4ed7a27dfd5f993f86e3&quality=origin&line=0&is_gif=0"},{"url":"http://i.snssdk.com/neihan/video/playback/?video_id=840aebabb21d4ed7a27dfd5f993f86e3&quality=origin&line=1&is_gif=0"}],"uri":"origin/840aebabb21d4ed7a27dfd5f993f86e3","height":360},"cover_image_url":"","activity":{},"group_id":5868963711,"is_video":1,"category_id":77}
         * comments : []
         * type : 1
         * display_time : 1451889512
         * online_time : 1451889512
         */

        private List<DataEntitys> data;

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public boolean isHas_new_message() {
            return has_new_message;
        }

        public void setHas_new_message(boolean has_new_message) {
            this.has_new_message = has_new_message;
        }

        public int getMax_time() {
            return max_time;
        }

        public void setMax_time(int max_time) {
            this.max_time = max_time;
        }

        public List<DataEntitys> getData() {
            return data;
        }

        public void setData(List<DataEntitys> data) {
            this.data = data;
        }


    }
}
