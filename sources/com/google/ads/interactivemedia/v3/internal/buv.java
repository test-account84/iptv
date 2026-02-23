package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class buv {
    private final Object a;
    private final int b;

    public buv(Object obj) {
        this.b = System.identityHashCode(obj);
        this.a = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof buv)) {
            return false;
        }
        buv buvVar = (buv) obj;
        return this.b == buvVar.b && this.a == buvVar.a;
    }

    public final int hashCode() {
        return this.b;
    }
}
