package com.google.ads.interactivemedia.v3.internal;

import java.util.HashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ank extends alz {
    public long a;
    public long b;

    public ank() {
        this.a = -1L;
        this.b = -1L;
    }

    public final HashMap b() {
        HashMap hashMap = new HashMap();
        hashMap.put(0, Long.valueOf(this.a));
        hashMap.put(1, Long.valueOf(this.b));
        return hashMap;
    }

    public ank(String str) {
        this.a = -1L;
        this.b = -1L;
        HashMap a = alz.a(str);
        if (a != null) {
            this.a = ((Long) a.get(0)).longValue();
            this.b = ((Long) a.get(1)).longValue();
        }
    }
}
