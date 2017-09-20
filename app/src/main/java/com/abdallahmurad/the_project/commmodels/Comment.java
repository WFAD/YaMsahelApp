package com.abdallahmurad.the_project.commmodels;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by AbdallahMurad on 8/4/2017.
 */
@IgnoreExtraProperties
public class Comment {
    public String uid;
    public String author;
    public String text;

    public Comment() {

    }

    public Comment(String uid, String author, String text) {
        this.uid = uid;
        this.author = author;
        this.text = text;
    }
}
