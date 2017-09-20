package com.abdallahmurad.the_project.Hotels;

/**
 * Created by Desmond on 8/1/2017.
 */

public class Hotel {

    private int hotelImage;
    private String hotelName;
    private String hotelDetails;
    private String hotelPrice;
    private String hotelTaxes;
    private int payNow;
    private int payAtHotel;
    private int favorite;
    int hotelStars;


    public Hotel(int hotelImage, String hotelName, String hotelDetails, String hotelPrice, String hotelTaxes, int payNow, int payAtHotel, int favorite) {
        this.hotelImage = hotelImage;
        this.hotelName = hotelName;
        this.hotelDetails = hotelDetails;
        this.hotelPrice = hotelPrice;
        this.hotelTaxes = hotelTaxes;
        this.payNow = payNow;
        this.payAtHotel = payAtHotel;
        this.favorite = favorite;
    }

    public int getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(int hotelImage) {
        this.hotelImage = hotelImage;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(String hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(String hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public String getHotelTaxes() {
        return hotelTaxes;
    }

    public void setHotelTaxes(String hotelTaxes) {
        this.hotelTaxes = hotelTaxes;
    }

    public int getPayNow() {
        return payNow;
    }

    public void setPayNow(int payNow) {
        this.payNow = payNow;
    }

    public int getPayAtHotel() {
        return payAtHotel;
    }

    public void setPayAtHotel(int payAtHotel) {
        this.payAtHotel = payAtHotel;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public int getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(int hotelStars) {
        this.hotelStars = hotelStars;
    }
}
