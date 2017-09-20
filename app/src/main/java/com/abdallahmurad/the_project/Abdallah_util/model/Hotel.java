package com.abdallahmurad.the_project.Abdallah_util.model;

import java.util.List;

/**
 * Created by AbdallahMurad on 8/28/2017.
 */

public class Hotel {

    private int id;
    private int cityId;
    private String name;
    private String description;
    private String phoneNumber;
    private Boolean favorite;
    private Boolean payWithCash;
    private Boolean payWithCreditCard;
    private MapLocation mapLocation;
    private List<String> images = null;
    private List<String> services = null;
    private Rating rating;
    private RoomsAvailable roomsAvailable;
    private List<Review> reviews = null;


    public Hotel(){}

    public Hotel(int id, int cityId, String name, String description,
                 String phoneNumber, Boolean favorite, Boolean payWithCash,
                 Boolean payWithCreditCard, MapLocation mapLocation, List<String> images,
                 List<String> services, Rating rating, RoomsAvailable roomsAvailable,
                 List<Review> reviews) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.favorite = favorite;
        this.payWithCash = payWithCash;
        this.payWithCreditCard = payWithCreditCard;
        this.mapLocation = mapLocation;
        this.images = images;
        this.services = services;
        this.rating = rating;
        this.roomsAvailable = roomsAvailable;
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Boolean getPayWithCash() {
        return payWithCash;
    }

    public void setPayWithCash(Boolean payWithCash) {
        this.payWithCash = payWithCash;
    }

    public Boolean getPayWithCreditCard() {
        return payWithCreditCard;
    }

    public void setPayWithCreditCard(Boolean payWithCreditCard) {
        this.payWithCreditCard = payWithCreditCard;
    }

    public MapLocation getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(MapLocation mapLocation) {
        this.mapLocation = mapLocation;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public RoomsAvailable getRoomsAvailable() {
        return roomsAvailable;
    }

    public void setRoomsAvailable(RoomsAvailable roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", cityId=" + cityId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", favorite=" + favorite +
                ", payWithCash=" + payWithCash +
                ", payWithCreditCard=" + payWithCreditCard +
                ", mapLocation=" + mapLocation +
                ", images=" + images +
                ", services=" + services +
                ", rating=" + rating +
                ", roomsAvailable=" + roomsAvailable +
                ", reviews=" + reviews +
                '}';
    }
}


