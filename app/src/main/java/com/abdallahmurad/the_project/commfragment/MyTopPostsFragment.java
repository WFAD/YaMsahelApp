package com.abdallahmurad.the_project.commfragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

/**
 * Created by AbdallahMurad on 8/3/2017.
 */

public class MyTopPostsFragment extends PostListFragment {
    public MyTopPostsFragment() {
    }

    @Override
    public Query getQuery(DatabaseReference mDatabase) {
        String myUserId = getUid();
        Query myTopPostsQuery = mDatabase.child("user-posts").child(myUserId).orderByChild("starCount");
        return myTopPostsQuery;
    }
}
