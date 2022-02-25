package com.project.dto;

public class Coordinates {

    private String latitude;
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString(){
        return "coordinates [ latitude=" + latitude + ",longitude=" + longitude + "]";
    }
}
