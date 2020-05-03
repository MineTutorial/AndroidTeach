package com.sun.androidlearn.ui.day08;

import java.io.Serializable;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2020/5/3
 * Question:
 * Description:
 * Train of thought: user
 */
public class Employer implements Serializable {

    /**
     * firstName : John
     * videos : [{"name":"John","time":"Doe","title":17,"sex":"male","height":170},{"firstName":"Anna","lastName":"Smith","age":17,"sex":"male","height":170},{"firstName":"Peter","lastName":"Jones","age":17,"sex":"male","height":170}]
     */

    private String firstName;
    private List<VideosBean> videos;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<VideosBean> getVideos() {
        return videos;
    }

    public void setVideos(List<VideosBean> videos) {
        this.videos = videos;
    }

    public static class VideosBean implements Serializable{
        /**
         * name : John
         * time : Doe
         * title : 17
         * sex : male
         * height : 170
         * firstName : Anna
         * lastName : Smith
         * age : 17
         */

        private String name;
        private String time;
        private int title;
        private String sex;
        private int height;
        private String firstName;
        private String lastName;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getTitle() {
            return title;
        }

        public void setTitle(int title) {
            this.title = title;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
