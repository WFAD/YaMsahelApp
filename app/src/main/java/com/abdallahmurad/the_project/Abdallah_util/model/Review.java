package com.abdallahmurad.the_project.Abdallah_util.model;

/**
 * Created by AbdallahMurad on 8/28/2017.
 */


public class Review {

    private int id;
    private String body;
    private String userName;
    private String userCountryFlag;
    private String rate;
    public Review(){}

    public Review(int id, String body, String userName,
                  String userCountryFlag, String rate) {
        this.id = id;
        this.body = body;
        this.userName = userName;
        this.userCountryFlag = userCountryFlag;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCountryFlag() {
        return userCountryFlag;
    }

    public void setUserCountryFlag(String userCountryFlag) {
        this.userCountryFlag = userCountryFlag;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", userName='" + userName + '\'' +
                ", userCountryFlag='" + userCountryFlag + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
