package com.abdallahmurad.the_project.Abdallah_util.model;

/**
 * Created by AbdallahMurad on 8/28/2017.
 */
public class RoomsAvailable {

    private int onePerson;
    private int twoPerson;
    private int threePerson;
    private int fourPerson;
    public RoomsAvailable(){}

    public RoomsAvailable(int onePerson, int twoPerson,
                          int threePerson, int fourPerson) {
        this.onePerson = onePerson;
        this.twoPerson = twoPerson;
        this.threePerson = threePerson;
        this.fourPerson = fourPerson;
    }

    public int getOnePerson() {
        return onePerson;
    }

    public void setOnePerson(int onePerson) {
        this.onePerson = onePerson;
    }

    public int getTwoPerson() {
        return twoPerson;
    }

    public void setTwoPerson(int twoPerson) {
        this.twoPerson = twoPerson;
    }

    public int getThreePerson() {
        return threePerson;
    }

    public void setThreePerson(int threePerson) {
        this.threePerson = threePerson;
    }

    public int getFourPerson() {
        return fourPerson;
    }

    public void setFourPerson(int fourPerson) {
        this.fourPerson = fourPerson;
    }

    @Override
    public String toString() {
        return "RoomsAvailable{" +
                "onePerson=" + onePerson +
                ", twoPerson=" + twoPerson +
                ", threePerson=" + threePerson +
                ", fourPerson=" + fourPerson +
                '}';
    }
}