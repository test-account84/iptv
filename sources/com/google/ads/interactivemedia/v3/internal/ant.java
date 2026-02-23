package com.google.ads.interactivemedia.v3.internal;

import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ant extends alz {
    public Long a;
    public Long b;

    public ant() {
    }

    public final HashMap b() {
        HashMap hashMap = new HashMap();
        hashMap.put(0, this.a);
        hashMap.put(1, this.b);
        return hashMap;
    }

    public ant(String str) {
        HashMap a = alz.a(str);
        if (a != null) {
            this.a = (Long) a.get(0);
            this.b = (Long) a.get(1);
        }
    }
}
