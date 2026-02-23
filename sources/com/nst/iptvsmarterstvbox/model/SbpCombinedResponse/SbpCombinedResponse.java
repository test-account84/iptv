package com.nst.iptvsmarterstvbox.model.SbpCombinedResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SbpCombinedResponse {

    @SerializedName("check-maintainencemode")
    @Expose
    private CheckMaintainencemode checkMaintainencemode;

    @SerializedName("get-allcombinedashrequest")
    @Expose
    private GetAllcombinedashrequest getAllcombinedashrequest;

    @SerializedName("get-announcements")
    @Expose
    private GetAnnouncements getAnnouncements;

    @SerializedName("get-apkversion")
    @Expose
    private GetApkversion getApkversion;

    @SerializedName("get-app-storage-prefences")
    @Expose
    private GetAppStoragePrefences getAppStoragePrefences;

    @SerializedName("get_lastupdated")
    @Expose
    private GetLastupdated getLastupdated;

    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("sc")
    @Expose
    private String sc;

    public CheckMaintainencemode getCheckMaintainencemode() {
        return this.checkMaintainencemode;
    }

    public GetAllcombinedashrequest getGetAllcombinedashrequest() {
        return this.getAllcombinedashrequest;
    }

    public GetAnnouncements getGetAnnouncements() {
        return this.getAnnouncements;
    }

    public GetApkversion getGetApkversion() {
        return this.getApkversion;
    }

    public GetAppStoragePrefences getGetAppStoragePrefences() {
        return this.getAppStoragePrefences;
    }

    public GetLastupdated getGetLastupdated() {
        return this.getLastupdated;
    }

    public String getResult() {
        return this.result;
    }

    public String getSc() {
        return this.sc;
    }

    public void setCheckMaintainencemode(CheckMaintainencemode checkMaintainencemode) {
        this.checkMaintainencemode = checkMaintainencemode;
    }

    public void setGetAllcombinedashrequest(GetAllcombinedashrequest getAllcombinedashrequest) {
        this.getAllcombinedashrequest = getAllcombinedashrequest;
    }

    public void setGetAnnouncements(GetAnnouncements getAnnouncements) {
        this.getAnnouncements = getAnnouncements;
    }

    public void setGetApkversion(GetApkversion getApkversion) {
        this.getApkversion = getApkversion;
    }

    public void setGetAppStoragePrefences(GetAppStoragePrefences getAppStoragePrefences) {
        this.getAppStoragePrefences = getAppStoragePrefences;
    }

    public void setGetLastupdated(GetLastupdated getLastupdated) {
        this.getLastupdated = getLastupdated;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setSc(String str) {
        this.sc = str;
    }
}
