package com.zky.basics.api.map.entity;

/**
 * Created by lk
 * Date 2019-11-19
 * Time 11:00
 * Detail:
 */
public class ProjectCountBean {
    private String xmType;
    private int num;


    public ProjectCountBean(String xmType, int num) {
        this.xmType = xmType;
        this.num = num;
    }


    public ProjectCountBean() {
    }


    public String getXmType() {
        return xmType;
    }

    public void setXmType(String xmType) {
        this.xmType = xmType;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
