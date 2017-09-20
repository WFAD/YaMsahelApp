package com.abdallahmurad.the_project.commfragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

/**
 * Created by AbdallahMurad on 8/3/2017.
 */

public class RecentPostsFragment extends PostListFragment {
    public RecentPostsFragment() {
    }

    @Override
    public Query getQuery(DatabaseReference mDatabase) {
        Query recentPostsQuery = mDatabase.child("posts").limitToFirst(100);
        return recentPostsQuery;
    }
}
