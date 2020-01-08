package com.zky.basics.api.user.entity;

/**
 * Created by lk
 * Date 2019-11-05
 * Time 15:16
 * Detail:
 */
public class UpdataBean {
    private String id;
    private String name;
    private int version;
    private Long fileLength;
    private String url;
    private Boolean updateForce;
    private String  updateInfo;
    private String qrCodeUrl;
    private String createDate;

    public UpdataBean() {
    }

    public UpdataBean(String id, String name, int version, Long fileLength, String url, Boolean updateForce, String updateInfo, String qrCodeUrl, String createDate) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.fileLength = fileLength;
        this.url = url;
        this.updateForce = updateForce;
        this.updateInfo = updateInfo;
        this.qrCodeUrl = qrCodeUrl;
        this.createDate = createDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Long getFileLength() {
        return fileLength;
    }

    public void setFileLength(Long fileLength) {
        this.fileLength = fileLength;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getUpdateForce() {
        return updateForce;
    }

    public void setUpdateForce(Boolean updateForce) {
        this.updateForce = updateForce;
    }

    public String getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
