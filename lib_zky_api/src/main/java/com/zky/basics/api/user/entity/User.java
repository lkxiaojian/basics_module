package com.zky.basics.api.user.entity;

import java.io.Serializable;


public class User implements Serializable {

    private Long code;
    private String userName;
    private String password;
    private String province;
    private String city;
    private String county;
    private String college;
    private String accountLevel;
    private String accountStatus;
    private String isAdmin;
    private String phone;
    private String headImg;
    private String createDate;


    public User() {
    }


    public User(Long code, String userName, String password, String province, String city, String county, String college, String accountLevel, String accountStatus, String isAdmin, String phone, String headImg, String createDate) {
        this.code = code;
        this.userName = userName;
        this.password = password;
        this.province = province;
        this.city = city;
        this.county = county;
        this.college = college;
        this.accountLevel = accountLevel;
        this.accountStatus = accountStatus;
        this.isAdmin = isAdmin;
        this.phone = phone;
        this.headImg = headImg;
        this.createDate = createDate;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getInfoLevel() {
        // 0-中央、2-省（自治区）、3-市（自治州）、4-县（区）、5-学校
        String l = "";
        if ("0".equals(accountLevel)) {
            l = "中央";

        } else if ("2".equals(accountLevel)) {
            l = "省（自治区）";
        } else if ("3".equals(accountLevel)) {
            l = "市（自治州）";
        } else if ("4".equals(accountLevel)) {
            l = "县（区）";
        } else if ("5".equals(accountLevel)) {
            l = "学校";
        }
        return l;

    }
}
