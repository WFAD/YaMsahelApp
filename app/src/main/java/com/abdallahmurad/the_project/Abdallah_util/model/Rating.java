package com.abdallahmurad.the_project.Abdallah_util.model;

/**
 * Created by AbdallahMurad on 8/28/2017.
 */
public class Rating {

    private String text;
    private String value;
    private String fiveStarCount;
    private String fourStarCount;
    private String threeStarCount;
    private String twoStarCount;
    private String oneStarCount;
    public Rating(){}
    public Rating(String text, String value, String fiveStarCount, String fourStarCount,
                  String threeStarCount, String twoStarCount, String oneStarCount) {
        this.text = text;
        this.value = value;
        this.fiveStarCount = fiveStarCount;
        this.fourStarCount = fourStarCount;
        this.threeStarCount = threeStarCount;
        this.twoStarCount = twoStarCount;
        this.oneStarCount = oneStarCount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFiveStarCount() {
        return fiveStarCount;
    }

    public void setFiveStarCount(String fiveStarCount) {
        this.fiveStarCount = fiveStarCount;
    }

    public String getFourStarCount() {
        return fourStarCount;
    }

    public void setFourStarCount(String fourStarCount) {
        this.fourStarCount = fourStarCount;
    }

    public String getThreeStarCount() {
        return threeStarCount;
    }

    public void setThreeStarCount(String threeStarCount) {
        this.threeStarCount = threeStarCount;
    }

    public String getTwoStarCount() {
        return twoStarCount;
    }

    public void setTwoStarCount(String twoStarCount) {
        this.twoStarCount = twoStarCount;
    }

    public String getOneStarCount() {
        return oneStarCount;
    }

    public void setOneStarCount(String oneStarCount) {
        this.oneStarCount = oneStarCount;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "text='" + text + '\'' +
                ", value='" + value + '\'' +
                ", fiveStarCount='" + fiveStarCount + '\'' +
                ", fourStarCount='" + fourStarCount + '\'' +
                ", threeStarCount='" + threeStarCount + '\'' +
                ", twoStarCount='" + twoStarCount + '\'' +
                ", oneStarCount='" + oneStarCount + '\'' +
                '}';
    }
}
