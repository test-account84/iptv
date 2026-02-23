package com.nst.iptvsmarterstvbox.model.callback;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nst.iptvsmarterstvbox.model.pojo.PanelAvailableChannelsPojo;
import com.nst.iptvsmarterstvbox.model.pojo.PanelCategoriesPojo;
import com.nst.iptvsmarterstvbox.model.pojo.PanelServerInfoPojo;
import com.nst.iptvsmarterstvbox.model.pojo.PanelUserInfoPojo;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class XtreamPanelAPICallback {

    @SerializedName("available_channels")
    @Expose
    public Map availableChannels;

    @SerializedName("categories")
    @Expose
    private PanelCategoriesPojo categories;

    @SerializedName("server_info")
    @Expose
    private PanelServerInfoPojo serverInfo;

    @SerializedName("user_info")
    @Expose
    private PanelUserInfoPojo userInfo;

    public Map getAvailableChannels() {
        return this.availableChannels;
    }

    public PanelCategoriesPojo getCategories() {
        return this.categories;
    }

    public PanelServerInfoPojo getServerInfo() {
        return this.serverInfo;
    }

    public PanelUserInfoPojo getUserInfo() {
        return this.userInfo;
    }

    public void setAvailableChannels(PanelAvailableChannelsPojo panelAvailableChannelsPojo) {
        this.availableChannels = (Map) panelAvailableChannelsPojo;
    }

    public void setCategories(PanelCategoriesPojo panelCategoriesPojo) {
        this.categories = panelCategoriesPojo;
    }

    public void setServerInfo(PanelServerInfoPojo panelServerInfoPojo) {
        this.serverInfo = panelServerInfoPojo;
    }

    public void setUserInfo(PanelUserInfoPojo panelUserInfoPojo) {
        this.userInfo = panelUserInfoPojo;
    }
}
