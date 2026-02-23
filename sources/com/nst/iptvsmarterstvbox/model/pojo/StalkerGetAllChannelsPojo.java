package com.nst.iptvsmarterstvbox.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StalkerGetAllChannelsPojo {

    @SerializedName("cur_page")
    @Expose
    private Integer curPage;

    @SerializedName("data")
    @Expose
    private List data = null;

    @SerializedName("max_page_items")
    @Expose
    private Integer maxPageItems;

    @SerializedName("selected_item")
    @Expose
    private Integer selectedItem;

    @SerializedName("total_items")
    @Expose
    private Integer totalItems;

    public Integer getCurPage() {
        return this.curPage;
    }

    public List getData() {
        return this.data;
    }

    public Integer getMaxPageItems() {
        return this.maxPageItems;
    }

    public Integer getSelectedItem() {
        return this.selectedItem;
    }

    public Integer getTotalItems() {
        return this.totalItems;
    }

    public void setCurPage(Integer num) {
        this.curPage = num;
    }

    public void setData(List list) {
        this.data = list;
    }

    public void setMaxPageItems(Integer num) {
        this.maxPageItems = num;
    }

    public void setSelectedItem(Integer num) {
        this.selectedItem = num;
    }

    public void setTotalItems(Integer num) {
        this.totalItems = num;
    }
}
