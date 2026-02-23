package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class uu implements wy {
    public final dc g;
    public final int h;
    public final s i;
    public final int j;
    public final long l;
    public final long m;
    protected final dv n;
    public final Object k = null;
    public final long f = sw.a();

    public uu(cy cyVar, dc dcVar, int i, s sVar, int i2, long j, long j2) {
        this.n = new dv(cyVar);
        this.g = dcVar;
        this.h = i;
        this.i = sVar;
        this.j = i2;
        this.l = j;
        this.m = j2;
    }

    public final long k() {
        return this.n.g();
    }

    public final Uri l() {
        return this.n.h();
    }

    public final Map m() {
        return this.n.i();
    }
}
