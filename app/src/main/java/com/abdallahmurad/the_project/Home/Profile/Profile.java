package com.abdallahmurad.the_project.Home.Profile;

/**
 * Created by Desmond on 8/26/2017.
 */

public class Profile {

    int profileImag;
    int profileBalance;
    String profileCurrancy;
    int profileIimageFeature;
    String profileFeature;


    public Profile(int profileImag, int profileBalance, String profileCurrancy) {
        this.profileImag = profileImag;
        this.profileBalance = profileBalance;
        this.profileCurrancy = profileCurrancy;
    }

    public Profile(int profileIimageFeature, String profileFeature) {
        this.profileIimageFeature = profileIimageFeature;
        this.profileFeature = profileFeature;
    }


    public int getProfileImag() {
        return profileImag;
    }

    public void setProfileImag(int profileImag) {
        this.profileImag = profileImag;
    }

    public int getProfileBalance() {
        return profileBalance;
    }

    public void setProfileBalance(int profileBalance) {
        this.profileBalance = profileBalance;
    }

    public String getProfileCurrancy() {
        return profileCurrancy;
    }

    public void setProfileCurrancy(String profileCurrancy) {
        this.profileCurrancy = profileCurrancy;
    }

    public int getProfileIimageFeature() {
        return profileIimageFeature;
    }

    public void setProfileIimageFeature(int profileIimageFeature) {
        this.profileIimageFeature = profileIimageFeature;
    }

    public String getProfileFeature() {
        return profileFeature;
    }

    public void setProfileFeature(String profileFeature) {
        this.profileFeature = profileFeature;
    }
}
