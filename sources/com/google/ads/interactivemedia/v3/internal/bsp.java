package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bsp implements Map.Entry, Comparable {
    final /* synthetic */ bst a;
    private final Comparable b;
    private Object c;

    public bsp(bst bstVar, Comparable comparable, Object obj) {
        this.a = bstVar;
        this.b = comparable;
        this.c = obj;
    }

    private static final boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final Comparable a() {
        return this.b;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.b.compareTo(((bsp) obj).b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return b(this.b, entry.getKey()) && b(this.c, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.b;
    }

    public final Object getValue() {
        return this.c;
    }

    public final int hashCode() {
        Comparable comparable = this.b;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.c;
        return hashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    public final Object setValue(Object obj) {
        bst.i(this.a);
        Object obj2 = this.c;
        this.c = obj;
        return obj2;
    }

    public final String toString() {
        return String.valueOf(this.b) + "=" + String.valueOf(this.c);
    }
}
