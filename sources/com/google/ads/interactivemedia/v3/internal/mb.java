package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class mb {
    public final long a;
    public final long b;
    private final String c;
    private int d;

    public mb(String str, long j, long j2) {
        this.c = str == null ? "" : str;
        this.a = j;
        this.b = j2;
    }

    public final Uri a(String str) {
        return af.l(str, this.c);
    }

    public final mb b(mb mbVar, String str) {
        String c = c(str);
        if (mbVar != null && c.equals(mbVar.c(str))) {
            long j = this.b;
            if (j != -1) {
                long j2 = this.a;
                if (j2 + j == mbVar.a) {
                    long j3 = mbVar.b;
                    return new mb(c, j2, j3 == -1 ? -1L : j + j3);
                }
            }
            long j4 = mbVar.b;
            if (j4 != -1) {
                long j5 = mbVar.a;
                if (j5 + j4 == this.a) {
                    return new mb(c, j5, j == -1 ? -1L : j4 + j);
                }
            }
        }
        return null;
    }

    public final String c(String str) {
        return af.m(str, this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && mb.class == obj.getClass()) {
            mb mbVar = (mb) obj;
            if (this.a == mbVar.a && this.b == mbVar.b && this.c.equals(mbVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((((int) this.a) + 527) * 31) + ((int) this.b)) * 31) + this.c.hashCode();
        this.d = hashCode;
        return hashCode;
    }

    public final String toString() {
        return "RangedUri(referenceUri=" + this.c + ", start=" + this.a + ", length=" + this.b + ")";
    }
}
