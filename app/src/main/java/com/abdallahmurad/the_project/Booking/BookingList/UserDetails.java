package com.abdallahmurad.the_project.Booking.BookingList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Desmond on 8/8/2017.
 */

public class UserDetails extends Rooms {


    private int numRoomsData;
    private int numNightsData;
    private int numAdultsData;
    private int numPriceData;
    private String currancy;
    private String detailsTaxesData;


    public UserDetails(int numRoomsData, int numNightsData, int numAdultsData, int numPriceData, String detailsTaxesData,String currancy) {
        this.numRoomsData = numRoomsData;
        this.numNightsData = numNightsData;
        this.numAdultsData = numAdultsData;
        this.numPriceData = numPriceData;
        this.currancy = currancy;
        this.detailsTaxesData = detailsTaxesData;
    }



    public String getCurrancy() {
        return currancy;
    }

    public void setCurrancy(String currancy) {
        this.currancy = currancy;
    }

    public String getDetailsTaxesData() {
        return detailsTaxesData;
    }

    public void setDetailsTaxesData(String detailsTaxesData) {
        this.detailsTaxesData = detailsTaxesData;
    }

    @Override
    public List<RoomInfo> getChildList() {
        return new ArrayList<>();
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    public int getNumRoomsData() {
        return numRoomsData;
    }

    public void setNumRoomsData(int numRoomsData) {
        this.numRoomsData = numRoomsData;
    }

    public int getNumNightsData() {
        return numNightsData;
    }

    public void setNumNightsData(int numNightsData) {
        this.numNightsData = numNightsData;
    }

    public int getNumAdultsData() {
        return numAdultsData;
    }

    public void setNumAdultsData(int numAdultsData) {
        this.numAdultsData = numAdultsData;
    }

    public int getNumPriceData() {
        return numPriceData;
    }

    public void setNumPriceData(int numPriceData) {
        this.numPriceData = numPriceData;
    }
}
