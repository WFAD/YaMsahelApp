package com.abdallahmurad.the_project.Home;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.abdallahmurad.the_project.Home.Cities.CitiesFragment;
import com.abdallahmurad.the_project.Home.Profile.ProfileFragment;
import com.abdallahmurad.the_project.R;
import com.abdallahmurad.the_project.commactivities.CommMainActivity;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;

import static com.abdallahmurad.the_project.FragmentUtils.addFragment;
import static com.abdallahmurad.the_project.FragmentUtils.replaceFragment;

public class HomeActivity extends AppCompatActivity {
    CallDialog callDialog;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addFragment(this, R.id.fragment_container, false, new CitiesFragment());
        callDialog = new CallDialog();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        BottomNavigationItem homeItem = new BottomNavigationItem("Home", ContextCompat.getColor(this, R.color.BottomNavItem), R.drawable.ic_home_black_24dp);
        BottomNavigationItem profileItem = new BottomNavigationItem("Profile", ContextCompat.getColor(this, R.color.BottomNavItem), R.drawable.ic_person);
        BottomNavigationItem chatItem = new BottomNavigationItem("Chat", ContextCompat.getColor(this, R.color.BottomNavItem), R.drawable.ic_chat);
        BottomNavigationItem communityItem = new BottomNavigationItem("Community", ContextCompat.getColor(this, R.color.BottomNavItem), R.drawable.ic_community_black_24dp);
        bottomNavigationView.addTab(homeItem);
        bottomNavigationView.addTab(communityItem);
        bottomNavigationView.addTab(profileItem);
        bottomNavigationView.addTab(chatItem);
        bottomNavigationView.setOnBottomNavigationItemClickListener(new OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                switch (index) {
                    case 0:
                        replaceFragment(HomeActivity.this, R.id.fragment_container, false, new CitiesFragment());
                        break;
                    case 1:
                        startActivity(new Intent(HomeActivity.this , CommMainActivity.class));
                        break;
                    case 2:
                        replaceFragment(HomeActivity.this, R.id.fragment_container, false, new ProfileFragment());

                        break;
                    case 3:
                        replaceFragment(HomeActivity.this, R.id.fragment_container, false, new ChatFragment());


                        break;
                }
            }
        });
    }
 }



