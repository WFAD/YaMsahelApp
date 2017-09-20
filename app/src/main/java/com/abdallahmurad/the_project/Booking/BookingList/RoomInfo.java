package com.abdallahmurad.the_project.Booking.BookingList;

/**
 * Created by Desmond on 8/6/2017.
 */

public class RoomInfo extends HotelRooms {

    private int maxAdults;
    private int adultsPerPrice;
    private double earnMony;
    private SlidingImage images;
    private boolean isRefundable;
    private boolean isWirelessFree;
    private boolean isParkingFree;


    public RoomInfo(int maxAdults, int adultsPerPrice, int priecPerAdult, String currancey, double earnMony, int numNights, int numRooms, SlidingImage images, boolean isRefundable, boolean isWirelessFree, boolean isParkingFree) {
        super(numNights, numRooms, priecPerAdult, currancey);
        this.maxAdults = maxAdults;
        this.adultsPerPrice = adultsPerPrice;
        this.earnMony = earnMony;
        this.images = images;
        this.isRefundable = isRefundable;
        this.isWirelessFree = isWirelessFree;
        this.isParkingFree = isParkingFree;


    }

    public int getMaxAdults() {
        return maxAdults;
    }

    public void setMaxAdults(int maxAdults) {
        this.maxAdults = maxAdults;
    }

    public int getAdultsPerPrice() {
        return adultsPerPrice;
    }

    public void setAdultsPerPrice(int adultsPerPrice) {
        this.adultsPerPrice = adultsPerPrice;
    }

    public double getEarnMony() {
        return earnMony;
    }

    public void setEarnMony(double earnMony) {
        this.earnMony = earnMony;
    }

    public SlidingImage getImages() {
        return images;
    }

    public void setImages(SlidingImage images) {
        this.images = images;
    }

    public boolean isRefundable() {
        return isRefundable;
    }

    public void setRefundable(boolean refundable) {
        isRefundable = refundable;
    }

    public boolean isWirelessFree() {
        return isWirelessFree;
    }

    public void setWirelessFree(boolean wirelessFree) {
        isWirelessFree = wirelessFree;
    }

    public boolean isParkingFree() {
        return isParkingFree;
    }

    public void setParkingFree(boolean parkingFree) {
        isParkingFree = parkingFree;

    }


}


