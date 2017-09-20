package com.abdallahmurad.the_project.Booking.BookingList;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;

/**
 * Created by Desmond on 8/8/2017.
 */

public class CustomViewPager extends ViewPager {


    public CustomViewPager(Context context) {
        super(context);
    }



    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }


}
