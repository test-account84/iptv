package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bux implements Map.Entry, Comparable, Serializable {
    private static final long serialVersionUID = 4954918890077093841L;

    public static bux c(Object obj, Object obj2) {
        return new buw(obj, obj2);
    }

    public abstract Object a();

    public abstract Object b();

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        bux buxVar = (bux) obj;
        return new buq().b(a(), buxVar.a()).b(b(), buxVar.b()).a();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (bto.C(a(), entry.getKey()) && bto.C(b(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public final Object getKey() {
        return a();
    }

    public final Object getValue() {
        return b();
    }

    public final int hashCode() {
        return a().hashCode() ^ b().hashCode();
    }

    public final String toString() {
        return "(" + String.valueOf(a()) + "," + String.valueOf(b()) + ")";
    }
}
