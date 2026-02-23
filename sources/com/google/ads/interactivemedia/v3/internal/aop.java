package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aop implements Callable {
    private final anw a;
    private final agl b;

    public aop(anw anwVar, agl aglVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.a = anwVar;
        this.b = aglVar;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.a.k() != null) {
            this.a.k().get();
        }
        agc c = this.a.c();
        if (c == null) {
            return null;
        }
        try {
            synchronized (this.b) {
                agl aglVar = this.b;
                byte[] av = c.av();
                aglVar.aU(av, av.length, bqb.a());
            }
            return null;
        } catch (bqw | NullPointerException unused) {
            return null;
        }
    }
}
