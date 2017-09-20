package com.abdallahmurad.the_project.commfragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.abdallahmurad.the_project.R;
import com.abdallahmurad.the_project.commactivities.CommPostDetailActivity;
import com.abdallahmurad.the_project.commmodels.Post;
import com.abdallahmurad.the_project.commviewholder.PostViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;

/**
 * Created by AbdallahMurad on 8/12/2017.
 */

public class MyFirebaseRecyclerAdapter extends FirebaseRecyclerAdapter<Post, PostViewHolder> {
    private static final String TAG = "FirebaseRecyclerAdapter";

    Query postsQuery;
    DatabaseReference mDatabase ;



    public MyFirebaseRecyclerAdapter(Class modelClass, int modelLayout, Class viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        this.postsQuery = ref;
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    protected void populateViewHolder(PostViewHolder viewHolder, final Post model, int position) {
        final DatabaseReference postRef = getRef(position);

        final String postKey = postRef.getKey();
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CommPostDetailActivity.class);
                intent.putExtra(CommPostDetailActivity.EXTRA_POST_KEY, postKey);
                v.getContext().startActivity(intent);
            }
        });
        if (model.stars.containsKey(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
            viewHolder.starView.setImageResource(R.drawable.ic_toggle_star_24);
        } else {
            viewHolder.starView.setImageResource(R.drawable.ic_toggle_star_outline_24);
        }
        viewHolder.bindToPost(model, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference globalPostRef = mDatabase.child("posts").child(postRef.getKey());
                DatabaseReference userPostRef = mDatabase.child("posts").child(model.uid).child(postRef.getKey());

                onStarClick(globalPostRef);
                onStarClick(userPostRef);
            }
        } );
    }
    private void onStarClick(DatabaseReference postRef){
        postRef.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                Post p = mutableData.getValue(Post.class);
                if (p == null) {
                    return Transaction.success(mutableData);
                }
                if (p.stars.containsKey(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                    p.starCount -= 1;
                    p.stars.remove(FirebaseAuth.getInstance().getCurrentUser().getUid());
                } else {
                    p.starCount += 1;
                    p.stars.put(FirebaseAuth.getInstance().getCurrentUser().getUid(), true);
                }
                mutableData.setValue(p);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                Log.d(TAG, "postTransaction:onComplete:" + databaseError);

            }
        });
    }
}
