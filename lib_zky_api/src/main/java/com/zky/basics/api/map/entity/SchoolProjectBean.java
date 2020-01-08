package com.zky.basics.api.map.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lk
 * Date 2019-11-19
 * Time 14:15
 * Detail:
 */
public class SchoolProjectBean implements Serializable {

    private static final long serialVersionUID = -5962317564930716588L;
    private String fund_cen;
    private String fund_pro;
    private String fund_cit;
    private String fund_rep_date;
    private String fund_tot;
    private String pro_usecode;
    private String fund_car_date;
    private String pro_rep_date;
    private String fund_progress;
    private String pro_detail;
    private String pro_REMARK;
    private String pro_car_date;
    private String fund_cou;
    private String fund_oth;
    private String pro_progress;
    private String pro_name;
    private String plan_id;
    private String xm_code;
    private String xm_type;
    private String school_id;
    private SelectFileData files;


    public SchoolProjectBean() {
    }


    public SchoolProjectBean(String fund_cen, String fund_pro, String fund_cit, String fund_rep_date, String fund_tot, String pro_usecode, String fund_car_date, String pro_rep_date, String fund_progress, String pro_detail, String pro_REMARK, String pro_car_date, String fund_cou, String fund_oth, String pro_progress, String pro_name, String plan_id, String xm_code, String xm_type, String schoolId) {
        this.fund_cen = fund_cen;
        this.fund_pro = fund_pro;
        this.fund_cit = fund_cit;
        this.fund_rep_date = fund_rep_date;
        this.fund_tot = fund_tot;
        this.pro_usecode = pro_usecode;
        this.fund_car_date = fund_car_date;
        this.pro_rep_date = pro_rep_date;
        this.fund_progress = fund_progress;
        this.pro_detail = pro_detail;
        this.pro_REMARK = pro_REMARK;
        this.pro_car_date = pro_car_date;
        this.fund_cou = fund_cou;
        this.fund_oth = fund_oth;
        this.pro_progress = pro_progress;
        this.pro_name = pro_name;
        this.plan_id = plan_id;
        this.xm_code = xm_code;
        this.xm_type = xm_type;
        this.school_id = schoolId;
    }

    public String getSchoolId() {
        return school_id;
    }

    public void setSchoolId(String schoolId) {
        this.school_id = schoolId;
    }

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public String getXm_code() {
        return xm_code;
    }

    public void setXm_code(String xm_code) {
        this.xm_code = xm_code;
    }

    public String getXm_type() {
        return xm_type;
    }

    public void setXm_type(String xm_type) {
        this.xm_type = xm_type;
    }

    public SelectFileData getFiles() {
        return files;
    }

    public void setFiles(SelectFileData files) {
        this.files = files;
    }


    public String getFund_cen() {
        return fund_cen;
    }

    public void setFund_cen(String fund_cen) {
        this.fund_cen = fund_cen;
    }

    public String getFund_pro() {
        return fund_pro;
    }

    public void setFund_pro(String fund_pro) {
        this.fund_pro = fund_pro;
    }

    public String getFund_cit() {
        return fund_cit;
    }

    public void setFund_cit(String fund_cit) {
        this.fund_cit = fund_cit;
    }

    public String getFund_rep_date() {
        return fund_rep_date;
    }

    public void setFund_rep_date(String fund_rep_date) {
        this.fund_rep_date = fund_rep_date;
    }

    public String getFund_tot() {
        return fund_tot;
    }

    public void setFund_tot(String fund_tot) {
        this.fund_tot = fund_tot;
    }

    public String getPro_usecode() {
        return pro_usecode;
    }

    public void setPro_usecode(String pro_usecode) {
        this.pro_usecode = pro_usecode;
    }

    public String getFund_car_date() {
        return fund_car_date;
    }

    public void setFund_car_date(String fund_car_date) {
        this.fund_car_date = fund_car_date;
    }

    public String getPro_rep_date() {
        return pro_rep_date;
    }

    public void setPro_rep_date(String pro_rep_date) {
        this.pro_rep_date = pro_rep_date;
    }

    public String getFund_progress() {
        return fund_progress;
    }

    public void setFund_progress(String fund_progress) {
        this.fund_progress = fund_progress;
    }

    public String getPro_detail() {
        return pro_detail;
    }

    public void setPro_detail(String pro_detail) {
        this.pro_detail = pro_detail;
    }

    public String getPro_REMARK() {
        return pro_REMARK;
    }

    public void setPro_REMARK(String pro_REMARK) {
        this.pro_REMARK = pro_REMARK;
    }

    public String getPro_car_date() {
        return pro_car_date;
    }

    public void setPro_car_date(String pro_car_date) {
        this.pro_car_date = pro_car_date;
    }

    public String getFund_cou() {
        return fund_cou;
    }

    public void setFund_cou(String fund_cou) {
        this.fund_cou = fund_cou;
    }

    public String getFund_oth() {
        return fund_oth;
    }

    public void setFund_oth(String fund_oth) {
        this.fund_oth = fund_oth;
    }

    public String getPro_progress() {
        return pro_progress;
    }

    public void setPro_progress(String pro_progress) {
        this.pro_progress = pro_progress;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getSchool_id() {
        return this.school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public static class SelectFileData implements Serializable {

        private static final long serialVersionUID = -6680245813209110213L;

        private List<SelectFile> projectPhoto;
        private List<SelectFile> projectVideo;
        private List<SelectFile> moneyPhoto;


        public SelectFileData() {
        }

        public SelectFileData(List<SelectFile> projectPhoto, List<SelectFile> projectVideo, List<SelectFile> moneyPhoto) {
            this.projectPhoto = projectPhoto;
            this.projectVideo = projectVideo;
            this.moneyPhoto = moneyPhoto;
        }

        public List<SelectFile> getProjectPhoto() {
            return projectPhoto;
        }

        public void setProjectPhoto(List<SelectFile> projectPhoto) {
            this.projectPhoto = projectPhoto;
        }

        public List<SelectFile> getProjectVideo() {
            return projectVideo;
        }

        public void setProjectVideo(List<SelectFile> projectVideo) {
            this.projectVideo = projectVideo;
        }

        public List<SelectFile> getMoneyPhoto() {
            return moneyPhoto;
        }

        public void setMoneyPhoto(List<SelectFile> moneyPhoto) {
            this.moneyPhoto = moneyPhoto;
        }
    }
}
