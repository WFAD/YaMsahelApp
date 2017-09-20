package com.abdallahmurad.the_project.BookingPage;

/**
 * Created by Desmond on 9/14/2017.
 */

public class BookNowData {


    private String hotelName;
    private String cityName;
    private String currantCurrancey;
    private String hotelCurrancy;
    private BookingCheck check;
    private double finalPrice;


    public BookNowData(String hotelName, String cityName, String currantCurrancey, String hotelCurrancy, BookingCheck check, double finalPrice) {
        this.hotelName = hotelName;
        this.cityName = cityName;
        this.currantCurrancey = currantCurrancey;
        this.hotelCurrancy = hotelCurrancy;
        this.check = check;
        this.finalPrice = finalPrice;
    }


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCurrantCurrancey() {
        return currantCurrancey;
    }

    public void setCurrantCurrancey(String currantCurrancey) {
        this.currantCurrancey = currantCurrancey;
    }

    public String getHotelCurrancy() {
        return hotelCurrancy;
    }

    public void setHotelCurrancy(String hotelCurrancy) {
        this.hotelCurrancy = hotelCurrancy;
    }

    public BookingCheck getCheck() {
        return check;
    }

    public void setCheck(BookingCheck check) {
        this.check = check;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
