package com.abdallahmurad.the_project.commactivities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.abdallahmurad.the_project.R;
import com.abdallahmurad.the_project.commimg_storge.MyUploadService;
import com.abdallahmurad.the_project.commmodels.Post;
import com.abdallahmurad.the_project.commmodels.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AbdallahMurad on 8/3/2017.
 */

public class CommNewPostActivity extends CommBaseActivity implements IPickResult {
    private static final String TAG = "CommNewPostActivity";
    private static final String REQUIRED = "required";


    private DatabaseReference mDatabase;

    private EditText mTitleField;
    private FloatingActionButton mSubmitButton;


    ImageView imageView;
    Button getImageBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mTitleField = (EditText) findViewById(R.id.field_title);
        mSubmitButton = (FloatingActionButton) findViewById(R.id.fab_submit_post);
        imageView = (ImageView) findViewById(R.id.imageView);
        getImageBtn = (Button) findViewById(R.id.uploadBtn);
        getImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickImageDialog.build(new PickSetup()).show(getSupportFragmentManager());
            }
        });
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitPost();
            }

        });

    }


    private void submitPost() {
        final String title = mTitleField.getText().toString();

        if (TextUtils.isEmpty(title)) {
            mTitleField.setError(REQUIRED);
            return;
        }

        final String userId = getUid();
        mDatabase.child("users").child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);

                if (user == null) {
                    Log.e(TAG, "User " + userId + " is unexpectedly null");
                    Toast.makeText(CommNewPostActivity.this, "Error: could not fetch user.", Toast.LENGTH_SHORT).show();
                } else {
                    String imgUrl = "http://via.placeholder.com/350x150";
                    writeNewPost(userId, user.username, title, imgUrl);
                }
                setEditingEnabled(true);
                finish();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                setEditingEnabled(true);
            }
        });
    }

    private void setEditingEnabled(boolean enabled) {
        mTitleField.setEnabled(enabled);
        if (enabled) {
            mSubmitButton.setVisibility(View.VISIBLE);
        } else {
            mSubmitButton.setVisibility(View.GONE);
        }
    }

    private void writeNewPost(String userId, String username, String title, String imgUrl) {

        String key = mDatabase.child("posts").push().getKey();
        Post post = new Post(userId, username, title, imgUrl);
        Map<String, Object> postValues = post.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + key, postValues);
        childUpdates.put("/user-posts/" + userId + "/" + key, postValues);
        mDatabase.updateChildren(childUpdates);
    }


    @Override
    public void onPickResult(PickResult pickResult) {
        if (pickResult.getError() == null) {
            Log.d(TAG, "onPickResult:");
            Log.d(TAG, "onPickResult:getUri:" + pickResult.getUri());
            Log.d(TAG, "onPickResult:getPath:" + pickResult.getPath());
            Log.d(TAG, "onPickResult:getBitmap:" + pickResult.getBitmap());

            String firebaseUrl = "https://firebasestorage.googleapis.com/v0/b/test001-c1b57.appspot.com/o/photos%2F6200?alt=media&token=af4ee852-52c0-42fd-bf99-c44086c8a8ed";
            Picasso.with(getApplicationContext()).load(firebaseUrl).into(imageView);

            Uri mFileUri = pickResult.getUri();
            Log.d("ttt", mFileUri+"");
            startService(new Intent(this, MyUploadService.class)
                    .putExtra(MyUploadService.EXTRA_FILE_URI, mFileUri)
                    .setAction(MyUploadService.ACTION_UPLOAD));
        } else {
            //TODO: do what you have to do with r.getError();
            Toast.makeText(this, pickResult.getError().getMessage(), Toast.LENGTH_LONG).show();
        }





    }



}
