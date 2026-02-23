package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class cz extends IOException {
    public final int a;

    public cz(int i) {
        this.a = i;
    }

    public cz(String str, Throwable th, int i) {
        super(str, th);
        this.a = i;
    }

    public cz(Throwable th, int i) {
        super(th);
        this.a = i;
    }
}
