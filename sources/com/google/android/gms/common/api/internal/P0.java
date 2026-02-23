package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class p0 extends C {
    public final com.google.android.gms.common.api.e c;

    public p0(com.google.android.gms.common.api.e eVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.c = eVar;
    }

    public final d e(d dVar) {
        return this.c.doRead(dVar);
    }

    public final d f(d dVar) {
        return this.c.doWrite(dVar);
    }

    public final Context h() {
        return this.c.getApplicationContext();
    }

    public final Looper i() {
        return this.c.getLooper();
    }
}
