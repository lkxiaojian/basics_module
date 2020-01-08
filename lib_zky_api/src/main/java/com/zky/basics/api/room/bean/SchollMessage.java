package com.zky.basics.api.room.bean;


/**
 * Created by lk
 * Date 2019-11-18
 * Time 11:42
 * Detail:
 */

public class SchollMessage {

    private String schoolId;

    private String name;

    private String value;
    //0 学校信息  1 基本情况
    private int type;

    private String newFild;


    public SchollMessage() {
    }


    public SchollMessage(String name, String value) {
        this.name = name;
        this.value = value;
    }


    public SchollMessage(String schoolId, String name, String value, int type) {
        this.schoolId = schoolId;
        this.name = name;
        this.value = value;
        this.type = type;
    }


    public SchollMessage(String schoolId, String name, String value, int type,
            String newFild) {
        this.schoolId = schoolId;
        this.name = name;
        this.value = value;
        this.type = type;
        this.newFild = newFild;
    }

    public String getNewFild() {
        return newFild;
    }

    public void setNewFild(String newFild) {
        this.newFild = newFild;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        if("null".equals(name)){
            return "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        if("null".equals(value)){
            return "";
        }
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
