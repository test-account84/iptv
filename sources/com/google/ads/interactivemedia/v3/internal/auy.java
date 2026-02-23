package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class auy extends ave {
    final /* synthetic */ avf a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public auy(avf avfVar) {
        super(avfVar);
        this.a = avfVar;
    }

    public final /* bridge */ /* synthetic */ Object a(int i) {
        return new auw(this.a, i);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int c = this.a.c(key);
            if (c != -1 && com.google.ads.interactivemedia.v3.impl.data.k.c(value, this.a.b[c])) {
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
        int d = this.a.d(key, F);
        if (d == -1 || !com.google.ads.interactivemedia.v3.impl.data.k.c(value, this.a.b[d])) {
            return false;
        }
        this.a.j(d, F);
        return true;
    }
}
