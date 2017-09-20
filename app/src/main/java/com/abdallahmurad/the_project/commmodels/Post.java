package com.abdallahmurad.the_project.commmodels;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AbdallahMurad on 8/3/2017.
 */
@IgnoreExtraProperties
public class Post {
    public String uid;
    public String author;
    public String title;
    public String imgUrl;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String uid, String author, String title , String imgUrl) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.imgUrl = imgUrl;
    }

    // [START post_to_map]
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("author", author);
        result.put("title", title);
        result.put("starCount", starCount);
        result.put("stars", stars);
        result.put("imgUrl", imgUrl);
        return result;
    }
    // [END post_to_map]
}
// [END post_class]
