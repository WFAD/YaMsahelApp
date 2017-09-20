package com.abdallahmurad.the_project.Booking;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Desmond on 8/5/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new PrePaidFragment();
        } else {
            return new PayAtHotelFragment();
        }

    }



    @Override
    public int getCount() {
        return 2;
    }
}
