package com.abdallahmurad.the_project.commactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.abdallahmurad.the_project.R;
import com.abdallahmurad.the_project.commfragment.MyPostsFragment;
import com.abdallahmurad.the_project.commfragment.RecentPostsFragment;
import com.abdallahmurad.the_project.commimg_storge.ImageActivity;
import com.google.firebase.auth.FirebaseAuth;

public class CommMainActivity extends AppCompatActivity {
        private static final String TAG = "ImageActivity";
        private FragmentPagerAdapter mPagerAdapter;
        private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comm_activity_main);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        Log.wtf(TAG, "onCreate: WTF Logging");
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[]{
                    new RecentPostsFragment(),
                    new MyPostsFragment()
            };
            private final String[] mFragmentNames = new String[]{
                    getString(R.string.heading_recent) ,
                    getString(R.string.heading_my_posts)

            };

            @Override
            public Fragment getItem(int position) {
                return mFragments[position];

            }

            @Override
            public int getCount() {
                return mFragments.length;
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentNames[position];
            }
        };
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        findViewById(R.id.fab_new_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommMainActivity.this , CommNewPostActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.comm_menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if (i == R.id.action_logout) {

            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, CommSignInActivity.class));
            finish();
            return true;
        } else if (i == R.id.imageUpload) {
            startActivity(new Intent(CommMainActivity.this , ImageActivity.class));
        } else {
            return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
