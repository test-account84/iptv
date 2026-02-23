package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bfm extends azh {
    private final int a;
    private final int b;
    private final bfl c;
    private final bfk d;

    public /* synthetic */ bfm(int i, int i2, bfl bflVar, bfk bfkVar) {
        super(null);
        this.a = i;
        this.b = i2;
        this.c = bflVar;
        this.d = bfkVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bfm)) {
            return false;
        }
        bfm bfmVar = (bfm) obj;
        return bfmVar.a == this.a && bfmVar.h() == h() && bfmVar.c == this.c && bfmVar.d == this.d;
    }

    public final int g() {
        return this.a;
    }

    public final int h() {
        bfl bflVar = this.c;
        if (bflVar == bfl.d) {
            return this.b;
        }
        if (bflVar == bfl.a || bflVar == bfl.b || bflVar == bfl.c) {
            return this.b + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.c, this.d});
    }

    public final bfl i() {
        return this.c;
    }

    public final boolean j() {
        return this.c != bfl.d;
    }

    public final String toString() {
        return "HMAC Parameters (variant: " + String.valueOf(this.c) + ", hashType: " + String.valueOf(this.d) + ", " + this.b + "-byte tags, and " + this.a + "-byte key)";
    }
}
