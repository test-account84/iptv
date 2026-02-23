package com.nst.iptvsmarterstvbox.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MultiUserDBModel {
    private String date;
    private String logged_in_using;
    private String m3uType;
    private String macAddress;
    private String magportal;
    private String magportal2;
    private String name;
    private String password;
    private String serverUrl;
    private String type;
    private String username;

    public MultiUserDBModel() {
    }

    public String getDate() {
        return this.date;
    }

    public String getLogged_in_using() {
        return this.logged_in_using;
    }

    public String getM3uType() {
        return this.m3uType;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public String getType() {
        return this.type;
    }

    public String getmagportal() {
        return this.magportal;
    }

    public String getmagportal2() {
        return this.magportal2;
    }

    public String getname() {
        return this.name;
    }

    public String getpassword() {
        return this.password;
    }

    public String getusername() {
        return this.username;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setLogged_in_using(String str) {
        this.logged_in_using = str;
    }

    public void setM3uType(String str) {
        this.m3uType = str;
    }

    public void setServerUrl(String str) {
        this.serverUrl = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setmacAddress(String str) {
        this.macAddress = str;
    }

    public void setmagportal(String str) {
        this.magportal = str;
    }

    public void setmagportal2(String str) {
        this.magportal2 = str;
    }

    public void setname(String str) {
        this.name = str;
    }

    public void setpassword(String str) {
        this.password = str;
    }

    public void setusername(String str) {
        this.username = str;
    }

    public MultiUserDBModel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.name = str;
        this.username = str2;
        this.password = str3;
        this.magportal = str4;
        this.magportal2 = str7;
        this.type = str5;
        this.m3uType = str6;
    }
}
