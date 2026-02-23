package com.nst.iptvsmarterstvbox.model;

import android.content.Context;
import com.nst.iptvsmarterstvbox.model.database.LiveStreamDBHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LiveStreamCategoryIdDBModel implements Serializable {
    private String alias;
    private String censored;
    private int id;
    private String liveStreamCategoryID;
    private String liveStreamCategoryName;
    private int liveStreamCounter;
    private int parentId;

    public LiveStreamCategoryIdDBModel() {
    }

    public static ArrayList listOfChannels(ArrayList arrayList, Context context, LiveStreamDBHandler liveStreamDBHandler) {
        if (context == null) {
            return null;
        }
        LiveStreamDBHandler liveStreamDBHandler2 = new LiveStreamDBHandler(context);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) it.next();
            String liveStreamCategoryID = liveStreamCategoryIdDBModel.getLiveStreamCategoryID();
            ArrayList allLiveStreasWithCategoryId = liveStreamDBHandler2.getAllLiveStreasWithCategoryId(liveStreamCategoryID, "live");
            Iterator it2 = liveStreamDBHandler2.getAllMovieCategoriesHavingParentIdNotZero(liveStreamCategoryID).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (liveStreamDBHandler2.getAllLiveStreasWithCategoryId(String.valueOf(((LiveStreamCategoryIdDBModel) it2.next()).getLiveStreamCategoryID()), "live").size() > 0) {
                    arrayList2.add(liveStreamCategoryIdDBModel);
                    break;
                }
            }
            if (allLiveStreasWithCategoryId.size() > 0) {
                arrayList2.add(liveStreamCategoryIdDBModel);
            }
        }
        return arrayList2;
    }

    public static ArrayList listOfMOview(ArrayList arrayList, Context context, LiveStreamDBHandler liveStreamDBHandler) {
        if (context == null) {
            return null;
        }
        LiveStreamDBHandler liveStreamDBHandler2 = new LiveStreamDBHandler(context);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LiveStreamCategoryIdDBModel liveStreamCategoryIdDBModel = (LiveStreamCategoryIdDBModel) it.next();
            String liveStreamCategoryID = liveStreamCategoryIdDBModel.getLiveStreamCategoryID();
            ArrayList allLiveStreasWithCategoryId = liveStreamDBHandler2.getAllLiveStreasWithCategoryId(liveStreamCategoryID, "movie");
            Iterator it2 = liveStreamDBHandler2.getAllMovieCategoriesHavingParentIdNotZero(liveStreamCategoryID).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (liveStreamDBHandler2.getAllLiveStreasWithCategoryId(String.valueOf(((LiveStreamCategoryIdDBModel) it2.next()).getLiveStreamCategoryID()), "movie").size() > 0) {
                    arrayList2.add(liveStreamCategoryIdDBModel);
                    break;
                }
            }
            if (allLiveStreasWithCategoryId.size() > 0) {
                arrayList2.add(liveStreamCategoryIdDBModel);
            }
        }
        return arrayList2;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getCensored() {
        return this.censored;
    }

    public int getId() {
        return this.id;
    }

    public String getLiveStreamCategoryID() {
        return this.liveStreamCategoryID;
    }

    public String getLiveStreamCategoryName() {
        return this.liveStreamCategoryName;
    }

    public int getLiveStreamCounter() {
        return this.liveStreamCounter;
    }

    public int getParentId() {
        return this.parentId;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setCensored(String str) {
        this.censored = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLiveStreamCategoryID(String str) {
        this.liveStreamCategoryID = str;
    }

    public void setLiveStreamCategoryName(String str) {
        this.liveStreamCategoryName = str;
    }

    public void setLiveStreamCounter(int i) {
        this.liveStreamCounter = i;
    }

    public void setParentId(int i) {
        this.parentId = i;
    }

    public LiveStreamCategoryIdDBModel(String str, String str2, int i) {
        this.liveStreamCategoryID = str;
        this.liveStreamCategoryName = str2;
        this.parentId = i;
    }
}
