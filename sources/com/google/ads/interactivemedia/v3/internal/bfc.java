package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bfc extends azh {
    private final int a;
    private final int b;
    private final bfb c;

    public /* synthetic */ bfc(int i, int i2, bfb bfbVar) {
        super(null);
        this.a = i;
        this.b = i2;
        this.c = bfbVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bfc)) {
            return false;
        }
        bfc bfcVar = (bfc) obj;
        return bfcVar.a == this.a && bfcVar.h() == h() && bfcVar.c == this.c;
    }

    public final int g() {
        return this.a;
    }

    public final int h() {
        bfb bfbVar = this.c;
        if (bfbVar == bfb.d) {
            return this.b;
        }
        if (bfbVar == bfb.a || bfbVar == bfb.b || bfbVar == bfb.c) {
            return this.b + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.c});
    }

    public final bfb i() {
        return this.c;
    }

    public final boolean j() {
        return this.c != bfb.d;
    }

    public final String toString() {
        return "AES-CMAC Parameters (variant: " + String.valueOf(this.c) + ", " + this.b + "-byte tags, and " + this.a + "-byte key)";
    }
}
