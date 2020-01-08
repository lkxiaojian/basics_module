package com.zky.basics.api.splash;

/**
 * Created by lk
 * Date 2019-11-06
 * Time 19:47
 * Detail:
 */
public class RegionOrSchoolBean {
    private String code;
    private String name;
    private String SCHOOL_NAME;
    private String SCHOOL_ID;

    public String getSCHOOL_NAME() {
        return SCHOOL_NAME;
    }

    public void setSCHOOL_NAME(String SCHOOL_NAME) {
        this.SCHOOL_NAME = SCHOOL_NAME;
    }

    public String getSCHOOL_ID() {
        return SCHOOL_ID;
    }

    public void setSCHOOL_ID(String SCHOOL_ID) {
        this.SCHOOL_ID = SCHOOL_ID;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
