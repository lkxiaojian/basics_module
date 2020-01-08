package com.zky.basics.api.map.entity;

import java.util.List;

/**
 * Created by lk
 * Date 2019-11-14
 * Time 15:47
 * Detail:
 */
public class JYBSchool {
    private int count;
    private List<Data> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Data> getList() {
        return list;
    }

    public void setList(List<Data> list) {
        this.list = list;
    }

    public JYBSchool() {
    }

    public JYBSchool(int count, List<Data> list) {
        this.count = count;
        this.list = list;
    }

   public class Data {
//        "SCHOOL_NAME": "阿图什市阿扎克乡麦依中学",   学校姓名
//
//"ORG_PRO": 65,                                                    组织机构(省)代码
//
//"ORG_CITY": 30,                                                    组织机构市)代码
//
//"ORG_COUNTY": 1,                                               组织机构(县)代码
//
//"latitude": null,                                               坐标
//
//"longitude": null,                                            坐标
//
//"USECODE": "12-综合楼",                               项目代码
//
//"ORG_PRO_NAME": "新疆维吾尔自治区",                省名称
//
//"ORG_CITY_NAME": "克孜勒苏柯尔克孜自治州",      市名称
//
//"ORG_COUNTY_NAME": "阿图什市"}]}                    县名称


        private String SCHOOL_NAME;
        private String ORG_CITY;
        private String ORG_COUNTY;
        private String latitude;
        private String longitude;
        private String USECODE;
        private String ORG_PRO_NAME;
        private String ORG_CITY_NAME;
        private String ORG_COUNTY_NAME;
        private String SCHOOL_ID;


        public Data() {
        }

        public Data(String SCHOOL_NAME, String ORG_CITY, String ORG_COUNTY, String latitude, String longitude, String USECODE, String ORG_PRO_NAME, String ORG_CITY_NAME, String ORG_COUNTY_NAME) {
            this.SCHOOL_NAME = SCHOOL_NAME;
            this.ORG_CITY = ORG_CITY;
            this.ORG_COUNTY = ORG_COUNTY;
            this.latitude = latitude;
            this.longitude = longitude;
            this.USECODE = USECODE;
            this.ORG_PRO_NAME = ORG_PRO_NAME;
            this.ORG_CITY_NAME = ORG_CITY_NAME;
            this.ORG_COUNTY_NAME = ORG_COUNTY_NAME;
        }


       public String getSCHOOL_ID() {
           return SCHOOL_ID;
       }

       public void setSCHOOL_ID(String SCHOOL_ID) {
           this.SCHOOL_ID = SCHOOL_ID;
       }

       public String getSCHOOL_NAME() {
            return SCHOOL_NAME;
        }

        public void setSCHOOL_NAME(String SCHOOL_NAME) {
            this.SCHOOL_NAME = SCHOOL_NAME;
        }

        public String getORG_CITY() {
            return ORG_CITY;
        }

        public void setORG_CITY(String ORG_CITY) {
            this.ORG_CITY = ORG_CITY;
        }

        public String getORG_COUNTY() {
            return ORG_COUNTY;
        }

        public void setORG_COUNTY(String ORG_COUNTY) {
            this.ORG_COUNTY = ORG_COUNTY;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getUSECODE() {
            return USECODE;
        }

        public void setUSECODE(String USECODE) {
            this.USECODE = USECODE;
        }

        public String getORG_PRO_NAME() {
            return ORG_PRO_NAME;
        }

        public void setORG_PRO_NAME(String ORG_PRO_NAME) {
            this.ORG_PRO_NAME = ORG_PRO_NAME;
        }

        public String getORG_CITY_NAME() {
            return ORG_CITY_NAME;
        }

        public void setORG_CITY_NAME(String ORG_CITY_NAME) {
            this.ORG_CITY_NAME = ORG_CITY_NAME;
        }

        public String getORG_COUNTY_NAME() {
            return ORG_COUNTY_NAME;
        }

        public void setORG_COUNTY_NAME(String ORG_COUNTY_NAME) {
            this.ORG_COUNTY_NAME = ORG_COUNTY_NAME;
        }
    }
}
