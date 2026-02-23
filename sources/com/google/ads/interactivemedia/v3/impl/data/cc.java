package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.UniversalAdId;
import com.google.ads.interactivemedia.v3.internal.bur;
import com.google.ads.interactivemedia.v3.internal.but;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class cc implements UniversalAdId {
    private String adIdValue = "unknown";
    private String adIdRegistry = "unknown";

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return bur.c(this, obj, new String[0]);
    }

    public String getAdIdRegistry() {
        return this.adIdRegistry;
    }

    public String getAdIdValue() {
        return this.adIdValue;
    }

    public int hashCode() {
        return but.a(this, new String[0]);
    }

    public void setAdIdRegistry(String str) {
        this.adIdRegistry = str;
    }

    public void setAdIdValue(String str) {
        this.adIdValue = str;
    }

    public String toString() {
        return "UniversalAdId [adIdValue=" + this.adIdValue + ", adIdRegistry=" + this.adIdRegistry + "]";
    }
}
