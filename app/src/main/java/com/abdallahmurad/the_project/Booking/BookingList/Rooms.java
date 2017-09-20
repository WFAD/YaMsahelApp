package com.abdallahmurad.the_project.Booking.BookingList;


import com.abdallahmurad.the_project.expandablerecyclerview.model.Parent;

import java.util.List;

/**
 * Created by Desmond on 8/6/2017.
 */

public class Rooms extends HotelRooms implements Parent<RoomInfo> {


    private int roomImage;
    private String roomType;
    private List<RoomInfo> roomInfoList;

    public Rooms(int roomImage, String roomType, int numNights, int numRooms, String currancey, int priecPerAdult, List<RoomInfo> roomInfoList) {
        super(numNights, numRooms, priecPerAdult, currancey);
        this.roomImage = roomImage;
        this.roomType = roomType;
        this.roomInfoList = roomInfoList;
    }

    public Rooms() {
    }

    @Override
    public List<RoomInfo> getChildList() {
        return roomInfoList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }


    public int getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(int roomImage) {
        this.roomImage = roomImage;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }


    public String getSomeInfo() {
        return getNumRooms() + " Room available from " + getCurrancey() + " " + getPriecPerAdult() + " (" + getNumNights() + " night)";
    }


}
