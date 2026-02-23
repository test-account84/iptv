package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bli implements Map.Entry {
    bli a;
    bli b;
    bli c;
    bli d;
    bli e;
    final Object f;
    final boolean g;
    Object h;
    int i;

    public bli(boolean z) {
        this.f = null;
        this.g = z;
        this.e = this;
        this.d = this;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.h;
                Object value = entry.getValue();
                if (obj3 == null) {
                    if (value == null) {
                        return true;
                    }
                } else if (obj3.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Object getKey() {
        return this.f;
    }

    public final Object getValue() {
        return this.h;
    }

    public final int hashCode() {
        Object obj = this.f;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.h;
        return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public final Object setValue(Object obj) {
        if (obj == null && !this.g) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.h;
        this.h = obj;
        return obj2;
    }

    public final String toString() {
        return String.valueOf(this.f) + "=" + String.valueOf(this.h);
    }

    public bli(boolean z, bli bliVar, Object obj, bli bliVar2, bli bliVar3) {
        this.a = bliVar;
        this.f = obj;
        this.g = z;
        this.i = 1;
        this.d = bliVar2;
        this.e = bliVar3;
        bliVar3.d = this;
        bliVar2.e = this;
    }
}
