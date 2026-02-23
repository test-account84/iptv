package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l {
    public final int a = 0;
    public final int b;
    public final int c;

    public l(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        int i = lVar.a;
        return this.b == lVar.b && this.c == lVar.c;
    }

    public final int hashCode() {
        return ((this.b + 16337) * 31) + this.c;
    }
}
