package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ServerInfoCallback {

    @SerializedName("https_port")
    @Expose
    private String httpsPort;

    @SerializedName("port")
    @Expose
    private String port;

    @SerializedName("rtmp_port")
    @Expose
    private String rtmpPort;

    @SerializedName("server_protocol")
    @Expose
    private String serverProtocal;

    @SerializedName("timestamp_now")
    @Expose
    private String timeCurrent;

    @SerializedName("time_now")
    @Expose
    private String timeNow;

    @SerializedName("timezone")
    @Expose
    private String timezone;

    @SerializedName("url")
    @Expose
    private String url;

    public String getHttpsPort() {
        return this.httpsPort;
    }

    public String getPort() {
        return this.port;
    }

    public String getRtmpPort() {
        return this.rtmpPort;
    }

    public String getServerProtocal() {
        return this.serverProtocal;
    }

    public String getTimeCurrent() {
        return this.timeCurrent;
    }

    public String getTimeNow() {
        return this.timeNow;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHttpsPort(String str) {
        this.httpsPort = str;
    }

    public void setPort(String str) {
        this.port = str;
    }

    public void setRtmpPort(String str) {
        this.rtmpPort = str;
    }

    public void setServerProtocal(String str) {
        this.serverProtocal = str;
    }

    public void setTimeCurrent(String str) {
        this.timeCurrent = str;
    }

    public void setTimeNow(String str) {
        this.timeNow = str;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
