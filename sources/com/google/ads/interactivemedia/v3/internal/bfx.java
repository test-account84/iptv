package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bfx {
    public static final bfx a = new bfw().a();
    private final Map b;

    public /* synthetic */ bfx(Map map) {
        this.b = map;
    }

    public final Map a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof bfx) {
            return this.b.equals(((bfx) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return this.b.toString();
    }
}
