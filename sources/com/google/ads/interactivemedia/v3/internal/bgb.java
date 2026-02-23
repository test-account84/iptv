package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bgb {
    private final bac a;
    private final int b;
    private final azh c;

    public /* synthetic */ bgb(bac bacVar, int i, azh azhVar, byte[] bArr) {
        this.a = bacVar;
        this.b = i;
        this.c = azhVar;
    }

    public final int a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bgb)) {
            return false;
        }
        bgb bgbVar = (bgb) obj;
        return this.a == bgbVar.a && this.b == bgbVar.b && this.c.equals(bgbVar.c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Integer.valueOf(this.b), Integer.valueOf(this.c.hashCode())});
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, parameters='%s')", new Object[]{this.a, Integer.valueOf(this.b), this.c});
    }
}
