package com.abdallahmurad.the_project.Booking.BookingList;

/**
 * Created by Desmond on 8/7/2017.
 */

public abstract class HotelRooms {


    protected int numNights;
    protected int numRooms;
    protected int priecPerAdult;
    protected String currancey;


    public HotelRooms(int numNights, int numRooms, int priecPerAdult, String currancey) {
        this.setNumNights(numNights);
        this.setNumRooms(numRooms);
        this.setPriecPerAdult(priecPerAdult);
        this.setCurrancey(currancey);

    }

    public HotelRooms() {

    }

    public int getNumNights() {
        return numNights;
    }

    public void setNumNights(int numNights) {
        this.numNights = numNights;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public int getPriecPerAdult() {
        return priecPerAdult;
    }

    public void setPriecPerAdult(int priecPerAdult) {
        this.priecPerAdult = priecPerAdult;
    }

    public String getCurrancey() {
        return currancey;
    }

    public void setCurrancey(String currancey) {
        this.currancey = currancey;
    }
}
