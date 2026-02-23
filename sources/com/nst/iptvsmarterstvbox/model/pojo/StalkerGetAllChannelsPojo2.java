package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StalkerGetAllChannelsPojo2 {

    @SerializedName("allow_local_pvr")
    @Expose
    private Integer allowLocalPvr;

    @SerializedName("allow_local_timeshift")
    @Expose
    private String allowLocalTimeshift;

    @SerializedName("allow_pvr")
    @Expose
    private Integer allowPvr;

    @SerializedName("allow_remote_pvr")
    @Expose
    private Integer allowRemotePvr;

    @SerializedName("archive")
    @Expose
    private Integer archive;

    @SerializedName("base_ch")
    @Expose
    private String baseCh;

    @SerializedName("bonus_ch")
    @Expose
    private String bonusCh;

    @SerializedName("censored")
    @Expose
    private String censored;

    @SerializedName("cmd")
    @Expose
    private String cmd;

    @SerializedName("cmd_1")
    @Expose
    private String cmd1;

    @SerializedName("cmd_2")
    @Expose
    private String cmd2;

    @SerializedName("cmd_3")
    @Expose
    private String cmd3;

    @SerializedName("correct_time")
    @Expose
    private String correctTime;

    @SerializedName("cost")
    @Expose
    private String cost;

    @SerializedName("count")
    @Expose
    private String count;

    @SerializedName("cur_playing")
    @Expose
    private String curPlaying;

    @SerializedName("enable_monitoring")
    @Expose
    private String enableMonitoring;

    @SerializedName("enable_tv_archive")
    @Expose
    private Integer enableTvArchive;

    @SerializedName("enable_wowza_load_balancing")
    @Expose
    private String enableWowzaLoadBalancing;

    @SerializedName("fav")
    @Expose
    private Integer fav;

    @SerializedName("genres_str")
    @Expose
    private String genresStr;

    @SerializedName("hd")
    @Expose
    private String hd;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("lock")
    @Expose
    private Integer lock;

    @SerializedName("locked")
    @Expose
    private Integer locked;

    @SerializedName("logo")
    @Expose
    private String logo;

    @SerializedName("mc_cmd")
    @Expose
    private String mcCmd;

    @SerializedName("modified")
    @Expose
    private String modified;

    @SerializedName("monitoring_status")
    @Expose
    private String monitoringStatus;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("nginx_secure_link")
    @Expose
    private String nginxSecureLink;

    @SerializedName("nimble_dvr")
    @Expose
    private String nimbleDvr;

    @SerializedName("number")
    @Expose
    private String number;

    @SerializedName("open")
    @Expose
    private Integer open;

    @SerializedName("pvr")
    @Expose
    private Integer pvr;

    @SerializedName("service_id")
    @Expose
    private String serviceId;

    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("tv_archive_duration")
    @Expose
    private Integer tvArchiveDuration;

    @SerializedName("tv_genre_id")
    @Expose
    private String tvGenreId;

    @SerializedName("use_http_tmp_link")
    @Expose
    private String useHttpTmpLink;

    @SerializedName("use_load_balancing")
    @Expose
    private Integer useLoadBalancing;

    @SerializedName("volume_correction")
    @Expose
    private String volumeCorrection;

    @SerializedName("wowza_dvr")
    @Expose
    private String wowzaDvr;

    @SerializedName("wowza_tmp_link")
    @Expose
    private String wowzaTmpLink;

    @SerializedName("xmltv_id")
    @Expose
    private String xmltvId;

    @SerializedName("epg")
    @Expose
    private List epg = null;

    @SerializedName("cmds")
    @Expose
    private List cmds = null;

    public Integer getAllowLocalPvr() {
        return this.allowLocalPvr;
    }

    public String getAllowLocalTimeshift() {
        return this.allowLocalTimeshift;
    }

    public Integer getAllowPvr() {
        return this.allowPvr;
    }

    public Integer getAllowRemotePvr() {
        return this.allowRemotePvr;
    }

    public Integer getArchive() {
        return this.archive;
    }

    public String getBaseCh() {
        return this.baseCh;
    }

    public String getBonusCh() {
        return this.bonusCh;
    }

    public String getCensored() {
        return this.censored;
    }

    public String getCmd() {
        return this.cmd;
    }

    public String getCmd1() {
        return this.cmd1;
    }

    public String getCmd2() {
        return this.cmd2;
    }

    public String getCmd3() {
        return this.cmd3;
    }

    public List getCmds() {
        return this.cmds;
    }

    public String getCorrectTime() {
        return this.correctTime;
    }

    public String getCost() {
        return this.cost;
    }

    public String getCount() {
        return this.count;
    }

    public String getCurPlaying() {
        return this.curPlaying;
    }

    public String getEnableMonitoring() {
        return this.enableMonitoring;
    }

    public Integer getEnableTvArchive() {
        return this.enableTvArchive;
    }

    public String getEnableWowzaLoadBalancing() {
        return this.enableWowzaLoadBalancing;
    }

    public List getEpg() {
        return this.epg;
    }

    public Integer getFav() {
        return this.fav;
    }

    public String getGenresStr() {
        return this.genresStr;
    }

    public String getHd() {
        return this.hd;
    }

    public String getId() {
        return this.id;
    }

    public Integer getLock() {
        return this.lock;
    }

    public Integer getLocked() {
        return this.locked;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getMcCmd() {
        return this.mcCmd;
    }

    public String getModified() {
        return this.modified;
    }

    public String getMonitoringStatus() {
        return this.monitoringStatus;
    }

    public String getName() {
        return this.name;
    }

    public String getNginxSecureLink() {
        return this.nginxSecureLink;
    }

    public String getNimbleDvr() {
        return this.nimbleDvr;
    }

    public String getNumber() {
        return this.number;
    }

    public Integer getOpen() {
        return this.open;
    }

    public Integer getPvr() {
        return this.pvr;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Integer getTvArchiveDuration() {
        return this.tvArchiveDuration;
    }

    public String getTvGenreId() {
        return this.tvGenreId;
    }

    public String getUseHttpTmpLink() {
        return this.useHttpTmpLink;
    }

    public Integer getUseLoadBalancing() {
        return this.useLoadBalancing;
    }

    public String getVolumeCorrection() {
        return this.volumeCorrection;
    }

    public String getWowzaDvr() {
        return this.wowzaDvr;
    }

    public String getWowzaTmpLink() {
        return this.wowzaTmpLink;
    }

    public String getXmltvId() {
        return this.xmltvId;
    }

    public void setAllowLocalPvr(Integer num) {
        this.allowLocalPvr = num;
    }

    public void setAllowLocalTimeshift(String str) {
        this.allowLocalTimeshift = str;
    }

    public void setAllowPvr(Integer num) {
        this.allowPvr = num;
    }

    public void setAllowRemotePvr(Integer num) {
        this.allowRemotePvr = num;
    }

    public void setArchive(Integer num) {
        this.archive = num;
    }

    public void setBaseCh(String str) {
        this.baseCh = str;
    }

    public void setBonusCh(String str) {
        this.bonusCh = str;
    }

    public void setCensored(String str) {
        this.censored = str;
    }

    public void setCmd(String str) {
        this.cmd = str;
    }

    public void setCmd1(String str) {
        this.cmd1 = str;
    }

    public void setCmd2(String str) {
        this.cmd2 = str;
    }

    public void setCmd3(String str) {
        this.cmd3 = str;
    }

    public void setCmds(List list) {
        this.cmds = list;
    }

    public void setCorrectTime(String str) {
        this.correctTime = str;
    }

    public void setCost(String str) {
        this.cost = str;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public void setCurPlaying(String str) {
        this.curPlaying = str;
    }

    public void setEnableMonitoring(String str) {
        this.enableMonitoring = str;
    }

    public void setEnableTvArchive(Integer num) {
        this.enableTvArchive = num;
    }

    public void setEnableWowzaLoadBalancing(String str) {
        this.enableWowzaLoadBalancing = str;
    }

    public void setEpg(List list) {
        this.epg = list;
    }

    public void setFav(Integer num) {
        this.fav = num;
    }

    public void setGenresStr(String str) {
        this.genresStr = str;
    }

    public void setHd(String str) {
        this.hd = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLock(Integer num) {
        this.lock = num;
    }

    public void setLocked(Integer num) {
        this.locked = num;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public void setMcCmd(String str) {
        this.mcCmd = str;
    }

    public void setModified(String str) {
        this.modified = str;
    }

    public void setMonitoringStatus(String str) {
        this.monitoringStatus = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNginxSecureLink(String str) {
        this.nginxSecureLink = str;
    }

    public void setNimbleDvr(String str) {
        this.nimbleDvr = str;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public void setOpen(Integer num) {
        this.open = num;
    }

    public void setPvr(Integer num) {
        this.pvr = num;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setTvArchiveDuration(Integer num) {
        this.tvArchiveDuration = num;
    }

    public void setTvGenreId(String str) {
        this.tvGenreId = str;
    }

    public void setUseHttpTmpLink(String str) {
        this.useHttpTmpLink = str;
    }

    public void setUseLoadBalancing(Integer num) {
        this.useLoadBalancing = num;
    }

    public void setVolumeCorrection(String str) {
        this.volumeCorrection = str;
    }

    public void setWowzaDvr(String str) {
        this.wowzaDvr = str;
    }

    public void setWowzaTmpLink(String str) {
        this.wowzaTmpLink = str;
    }

    public void setXmltvId(String str) {
        this.xmltvId = str;
    }
}
