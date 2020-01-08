package com.zky.basics.api.map.entity;

import com.zky.basics.api.config.API;

import java.io.Serializable;

/**
 * Created by lk
 * Date 2019-11-19
 * Time 17:18
 * Detail:
 */
public class SelectFile implements Serializable {
    private static final long serialVersionUID = -8525188848533964252L;
    private String fileType;
    private String filePath;
    private String fileName;
    private String createDate;
    private String titleId;
    private String fileCategory;
    private String videoImagePath;
    private boolean isUpload = false;//true 未上传  false  已上传  默认已上传
    private String plan_id;
    private String xm_code;
    private String xm_type;
    private String schoolId;

    private String code;

    private String tmpCode;


    public SelectFile() {
    }


    public SelectFile(String fileType, String filePath, String fileName, String createDate, String titleId, String fileCategory, String videoImagePath, boolean isUpload, String plan_id, String xm_code, String xm_type, String schoolId) {
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileName = fileName;
        this.createDate = createDate;
        this.titleId = titleId;
        this.fileCategory = fileCategory;
        this.videoImagePath = videoImagePath;
        this.isUpload = isUpload;
        this.plan_id = plan_id;
        this.xm_code = xm_code;
        this.xm_type = xm_type;
        this.schoolId = schoolId;
    }


    public SelectFile(String fileType, String filePath, String fileName, String createDate, String titleId, String fileCategory, String videoImagePath, boolean isUpload, String plan_id, String xm_code, String xm_type, String schoolId, String code) {
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileName = fileName;
        this.createDate = createDate;
        this.titleId = titleId;
        this.fileCategory = fileCategory;
        this.videoImagePath = videoImagePath;
        this.isUpload = isUpload;
        this.plan_id = plan_id;
        this.xm_code = xm_code;
        this.xm_type = xm_type;
        this.schoolId = schoolId;
        this.code = code;
    }


    public String getTmpCode() {
        return tmpCode;
    }

    public void setTmpCode(String tmpCode) {
        this.tmpCode = tmpCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public boolean isUpload() {
        return isUpload;
    }

    public void setUpload(boolean upload) {
        isUpload = upload;
    }

    public String getVideoImagePath() {
        return videoImagePath;
    }

    public void setVideoImagePath(String videoImagePath) {
        this.videoImagePath = videoImagePath;
    }

    public String getFileCategory() {
        return fileCategory;
    }

    public void setFileCategory(String fileCategory) {
        this.fileCategory = fileCategory;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {

        if (filePath != null && !filePath.startsWith("/storage/emulated/0") && !filePath.startsWith("http")) {
            filePath = API.ImageFolderPath + filePath;
        }

        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCreateTime() {
        return createDate;
    }

    public void setCreateTime(String createTime) {
        this.createDate = createTime;
    }

    public boolean getIsUpload() {
        return this.isUpload;
    }

    public void setIsUpload(boolean isUpload) {
        this.isUpload = isUpload;
    }
}
