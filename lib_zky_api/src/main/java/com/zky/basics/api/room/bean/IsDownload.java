package com.zky.basics.api.room.bean;

/**
 * Created by lk
 * Date 2019-11-21
 * Time 17:06
 * Detail:
 */

public class IsDownload {

    private String schoolId;


    public IsDownload() {
    }


    public IsDownload(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }


}
