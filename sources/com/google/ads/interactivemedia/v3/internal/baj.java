package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class baj {
    private final Object a;
    private final byte[] b;
    private final bid c;
    private final int d;
    private final azu e;
    private final int f;

    public baj(Object obj, byte[] bArr, int i, bid bidVar, int i2, azu azuVar) {
        this.a = obj;
        this.b = Arrays.copyOf(bArr, bArr.length);
        this.f = i;
        this.c = bidVar;
        this.d = i2;
        this.e = azuVar;
    }

    public final int a() {
        return this.d;
    }

    public final azu b() {
        return this.e;
    }

    public final bid c() {
        return this.c;
    }

    public final Object d() {
        return this.a;
    }

    public final byte[] e() {
        byte[] bArr = this.b;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int f() {
        return this.f;
    }

    public final azh g() {
        return this.e.a();
    }
}
