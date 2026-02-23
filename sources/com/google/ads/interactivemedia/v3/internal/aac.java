package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aac {
    public static final aac a = new aac(0, 0);
    public final long b;
    public final long c;

    public aac(long j, long j2) {
        this.b = j;
        this.c = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && aac.class == obj.getClass()) {
            aac aacVar = (aac) obj;
            if (this.b == aacVar.b && this.c == aacVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.b) * 31) + ((int) this.c);
    }

    public final String toString() {
        return "[timeUs=" + this.b + ", position=" + this.c + "]";
    }
}
