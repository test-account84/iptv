package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.CompanionAd;
import com.google.ads.interactivemedia.v3.internal.bur;
import com.google.ads.interactivemedia.v3.internal.but;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class CompanionAdImpl implements CompanionAd {
    private String apiFramework;
    private String resourceValue;
    private by size = by.create(0, 0);

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return bur.c(this, obj, new String[0]);
    }

    public String getApiFramework() {
        return this.apiFramework;
    }

    public int getHeight() {
        return this.size.height().intValue();
    }

    public String getResourceValue() {
        return this.resourceValue;
    }

    public int getWidth() {
        return this.size.width().intValue();
    }

    public int hashCode() {
        return but.a(this, new String[0]);
    }

    public void setApiFramework(String str) {
        this.apiFramework = str;
    }

    public void setResourceValue(String str) {
        this.resourceValue = str;
    }

    public void setSize(by byVar) {
        this.size = byVar;
    }

    public String toString() {
        return "CompanionAd [apiFramework=" + this.apiFramework + ", resourceUrl=" + this.resourceValue + ", width=" + this.size.width() + ", height=" + this.size.height() + "]";
    }
}
