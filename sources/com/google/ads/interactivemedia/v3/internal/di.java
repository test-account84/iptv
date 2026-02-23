package com.google.ads.interactivemedia.v3.internal;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class di extends auu {
    private final Map a;

    public di(Map map) {
        this.a = map;
    }

    public final /* synthetic */ Object a() {
        return this.a;
    }

    public final Map b() {
        return this.a;
    }

    public final boolean containsKey(Object obj) {
        return obj != null && super.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        return super.d(obj);
    }

    public final Set entrySet() {
        return axo.e(b().entrySet(), dh.b);
    }

    public final boolean equals(Object obj) {
        return obj != null && super.e(obj);
    }

    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) b().get(obj);
    }

    public final int hashCode() {
        return super.c();
    }

    public final boolean isEmpty() {
        if (b().isEmpty()) {
            return true;
        }
        return super.size() == 1 && super.containsKey(null);
    }

    public final Set keySet() {
        return axo.e(b().keySet(), dh.a);
    }

    public final int size() {
        return super.size() - (super.containsKey(null) ? 1 : 0);
    }
}
