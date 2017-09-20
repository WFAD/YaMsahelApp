package com.abdallahmurad.the_project.Abdallah_util.model;

/**
 * Created by AbdallahMurad on 8/28/2017.
 */

public class MapLocation {

    private String vertical;
    private String horezantl;

    public MapLocation(String vertical, String horezantl) {
        this.vertical = vertical;
        this.horezantl = horezantl;
    }

    public MapLocation(){}

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getHorezantl() {
        return horezantl;
    }

    public void setHorezantl(String horezantl) {
        this.horezantl = horezantl;
    }

    @Override
    public String toString() {
        return "MapLocation{" +
                "vertical='" + vertical + '\'' +
                ", horezantl='" + horezantl + '\'' +
                '}';
    }
}
