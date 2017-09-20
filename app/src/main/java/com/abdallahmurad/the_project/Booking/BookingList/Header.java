package com.abdallahmurad.the_project.Booking.BookingList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Desmond on 8/8/2017.
 */

public class Header extends Rooms {

    int headerImageData;
    String headerTitleData;


    public Header(int headerImageData, String headerTitleData) {
        this.headerImageData = headerImageData;
        this.headerTitleData = headerTitleData;
    }


    public int getHeaderImageData() {
        return headerImageData;
    }

    public void setHeaderImageData(int headerImageData) {
        this.headerImageData = headerImageData;
    }

    public String getHeaderTitleData() {
        return headerTitleData;
    }

    public void setHeaderTitleData(String headerTitleData) {
        this.headerTitleData = headerTitleData;
    }

    @Override
    public List<RoomInfo> getChildList() {
        return new ArrayList<>();
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
