package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bj {
    public final int a;
    private final bf b;
    private final boolean c;
    private final int[] d;
    private final boolean[] e;

    public bj(bf bfVar, boolean z, int[] iArr, boolean[] zArr) {
        int i = bfVar.a;
        this.a = i;
        af.u(i == iArr.length && i == zArr.length);
        this.b = bfVar;
        this.c = z && i > 1;
        this.d = (int[]) iArr.clone();
        this.e = (boolean[]) zArr.clone();
    }

    public final int a() {
        return this.b.c;
    }

    public final s b(int i) {
        return this.b.b(i);
    }

    public final boolean c() {
        for (boolean z : this.e) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(int i) {
        return this.e[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && bj.class == obj.getClass()) {
            bj bjVar = (bj) obj;
            if (this.c == bjVar.c && this.b.equals(bjVar.b) && Arrays.equals(this.d, bjVar.d) && Arrays.equals(this.e, bjVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.b.hashCode() * 31) + (this.c ? 1 : 0)) * 31) + Arrays.hashCode(this.d)) * 31) + Arrays.hashCode(this.e);
    }
}
