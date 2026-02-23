package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class or extends vc {
    private byte[] a;

    public or(cy cyVar, dc dcVar, s sVar, int i, byte[] bArr) {
        super(cyVar, dcVar, sVar, i, bArr);
    }

    public final void a(byte[] bArr, int i) {
        this.a = Arrays.copyOf(bArr, i);
    }

    public final byte[] b() {
        return this.a;
    }
}
