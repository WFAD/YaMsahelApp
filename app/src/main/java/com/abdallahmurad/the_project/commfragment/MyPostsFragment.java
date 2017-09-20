package com.abdallahmurad.the_project.commfragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

/**
 * Created by AbdallahMurad on 8/3/2017.
 */

public class MyPostsFragment extends PostListFragment {

    public MyPostsFragment() {

    }

    @Override
    public Query getQuery(DatabaseReference mDatabase) {
        return mDatabase.child("user-posts").child(getUid());
    }

}
