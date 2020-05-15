package com.sun.androidlearn.data;

import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2020/5/12
 * Question:
 * Description:
 * Train of thought:
 */
public class LiveDataModel {

    private List<RecommendBean> recommend;
    private List<ListBean> list;
    private StyleData style_list;


    public List<RecommendBean> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<RecommendBean> recommend) {
        this.recommend = recommend;
    }

    public StyleData getStyle_list() {
        return style_list;
    }

    public void setStyle_list(StyleData style_list) {
        this.style_list = style_list;
    }

    public List<ListBean> getList() {
        return list;
    }
    public void setList(List<ListBean> list) {
        this.list = list;
    }


    public static class StyleData{
        private String title;//直播。关注
        private List<StyleList> list;


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<StyleList> getList() {
            return list;
        }

        public void setList(List<StyleList> list) {
            this.list = list;
        }

        public static class StyleList{
            private String src;
            private String title;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

    }


    public static class RecommendBean {
        /**
         * src : https://i0.hdslb.com/bfs/archive/acf2c0ea2d20ffc58b74c4d3870b06c4f6620313.jpg@880w_388h_1c_95q
         * link_url : https://www.bilibili.com/blackboard/bigwriter4-vote.html
         * text : 奖品有限，送完即止
         */

        private String src;
        private String link_url;
        private String text;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getLink_url() {
            return link_url;
        }

        public void setLink_url(String link_url) {
            this.link_url = link_url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class ListBean {
        /**
         * src : https://i1.hdslb.com/bfs/archive/1eede73d8dc7e124d6edd372c0adfe92f0a1e831.jpg@206w_116h_1c_100q.webp
         * link : https://www.bilibili.com/video/BV1RV411R7V3?spm_id_from=333.5.b_646f7567615f6d6164.13
         * text : 川粤火线！
         * user : {"pic":"https://i2.hdslb.com/bfs/face/de7d96e6c4879efe3bffc000d6b27232506f9338.jpg@68w_68h.webp","name":"八月份的欠揍zz","sex":1,"age":18}
         * desc : 一帧一帧扣，蛮辛苦的吧
         * day : VOL.2775 12 May 2020
         * play_nums : 27
         * same_video : 13
         * duration : 10:22
         * like : 600
         */

        private String src;
        private String link;
        private String text;
        private UserBean user;
        private String desc;
        private String day;
        private int play_nums;
        private int same_video;
        private String duration;
        private int like;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getPlay_nums() {
            return play_nums;
        }

        public void setPlay_nums(int play_nums) {
            this.play_nums = play_nums;
        }

        public int getSame_video() {
            return same_video;
        }

        public void setSame_video(int same_video) {
            this.same_video = same_video;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public static class UserBean {
            /**
             * pic : https://i2.hdslb.com/bfs/face/de7d96e6c4879efe3bffc000d6b27232506f9338.jpg@68w_68h.webp
             * name : 八月份的欠揍zz
             * sex : 1
             * age : 18
             */

            private String pic;
            private String name;
            private int sex;
            private int age;

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }
    }
}
