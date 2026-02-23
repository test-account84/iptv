package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ava extends ave {
    public ava(avf avfVar) {
        super(avfVar);
    }

    public final /* bridge */ /* synthetic */ Object a(int i) {
        return new aux(this.b, i);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int e = this.b.e(key);
            if (e != -1 && com.google.ads.interactivemedia.v3.impl.data.k.c(this.b.a[e], value)) {
                return true;
            }
        }
        return false;
    }

    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        int F = axo.F(key);
        int f = this.b.f(key, F);
        if (f == -1 || !com.google.ads.interactivemedia.v3.impl.data.k.c(this.b.a[f], value)) {
            return false;
        }
        this.b.k(f, F);
        return true;
    }
}
