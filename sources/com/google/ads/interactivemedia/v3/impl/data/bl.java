package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.bur;
import com.google.ads.interactivemedia.v3.internal.but;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bl {
    public int errorCode;
    public String errorMessage;
    public String innerError;
    public String type;

    public Map constructMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", this.type);
        hashMap.put("errorCode", String.valueOf(this.errorCode));
        hashMap.put("errorMessage", this.errorMessage);
        String str = this.innerError;
        if (str != null) {
            hashMap.put("innerError", str);
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return bur.c(this, obj, new String[0]);
    }

    public int hashCode() {
        return but.a(this, new String[0]);
    }

    public String toString() {
        return String.format("Log[type=%s, errorCode=%s, errorMessage=%s, innerError=%s]", new Object[]{this.type, Integer.valueOf(this.errorCode), this.errorMessage, this.innerError});
    }
}
