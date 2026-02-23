package com.google.ads.interactivemedia.v3.internal;

import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class anq extends alz {
    public Long a;
    public Boolean b;
    public Boolean c;

    public anq() {
    }

    public final HashMap b() {
        HashMap hashMap = new HashMap();
        hashMap.put(0, this.a);
        hashMap.put(1, this.b);
        hashMap.put(2, this.c);
        return hashMap;
    }

    public anq(String str) {
        HashMap a = alz.a(str);
        if (a != null) {
            this.a = (Long) a.get(0);
            this.b = (Boolean) a.get(1);
            this.c = (Boolean) a.get(2);
        }
    }
}
