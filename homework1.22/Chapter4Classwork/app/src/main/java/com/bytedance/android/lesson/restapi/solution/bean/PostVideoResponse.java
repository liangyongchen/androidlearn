package com.bytedance.android.lesson.restapi.solution.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author Xavier.S
 * @date 2019.01.18 17:53
 */
public class PostVideoResponse {

    // TODO-C2 (3) Implement your PostVideoResponse Bean here according to the response json
    @SerializedName("student_id")
    String student_id;
    @SerializedName("user_name")
    String user_name;
    @SerializedName("image_url")
    String image_url;
    @SerializedName("video_url")
    String video_url;

    public String getstudent_id() {
        return student_id;
    }

    public void setstudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getuser_name() {
        return user_name;
    }

    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getimage_url() {
        return image_url;
    }

    public void setimage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getvideo_url() {
        return video_url;
    }

    public void setvideo_url(String video_url) {
        this.video_url = video_url;
    }
}
