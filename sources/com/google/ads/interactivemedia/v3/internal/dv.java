package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class dv implements cy {
    private final cy a;
    private long b;
    private Uri c;
    private Map d;

    public dv(cy cyVar) {
        af.s(cyVar);
        this.a = cyVar;
        this.c = Uri.EMPTY;
        this.d = Collections.emptyMap();
    }

    public final int a(byte[] bArr, int i, int i2) throws IOException {
        int a = this.a.a(bArr, i, i2);
        if (a != -1) {
            this.b += a;
        }
        return a;
    }

    public final long b(dc dcVar) throws IOException {
        this.c = dcVar.a;
        this.d = Collections.emptyMap();
        long b = this.a.b(dcVar);
        Uri c = c();
        af.s(c);
        this.c = c;
        this.d = e();
        return b;
    }

    public final Uri c() {
        return this.a.c();
    }

    public final void d() throws IOException {
        this.a.d();
    }

    public final Map e() {
        return this.a.e();
    }

    public final void f(dw dwVar) {
        af.s(dwVar);
        this.a.f(dwVar);
    }

    public final long g() {
        return this.b;
    }

    public final Uri h() {
        return this.c;
    }

    public final Map i() {
        return this.d;
    }

    public final void j() {
        this.b = 0L;
    }
}
