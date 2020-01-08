package com.zky.basics.api.map.entity;


/**
 * Created by lk
 * Date 2019-11-23
 * Time 11:08
 * Detail:
 */

public class SchoolLocationBean {

    private String schoolId;
    private String longitude;
    private String latitude;


    public SchoolLocationBean() {
    }


    public SchoolLocationBean(String schoolId, String longitude, String latitude) {
        this.schoolId = schoolId;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
