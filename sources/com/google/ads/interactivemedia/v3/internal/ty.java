package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Looper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ty extends sa implements tr {
    private final ai a;
    private final ad b;
    private final cx c;
    private final nt d;
    private final int e;
    private boolean f;
    private long g;
    private boolean h;
    private boolean i;
    private dw j;
    private final xv k;
    private final ws l;

    public /* synthetic */ ty(ai aiVar, cx cxVar, xv xvVar, nt ntVar, ws wsVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ad adVar = aiVar.b;
        af.s(adVar);
        this.b = adVar;
        this.a = aiVar;
        this.c = cxVar;
        this.k = xvVar;
        this.d = ntVar;
        this.l = wsVar;
        this.e = i;
        this.f = true;
        this.g = -9223372036854775807L;
    }

    private final void c() {
        long j = this.g;
        boolean z = this.h;
        boolean z2 = this.i;
        ai aiVar = this.a;
        uj ujVar = new uj(-9223372036854775807L, -9223372036854775807L, j, j, 0L, 0L, z, false, false, null, aiVar, z2 ? aiVar.c : null);
        G(this.f ? new tw(ujVar) : ujVar);
    }

    public final ai a() {
        return this.a;
    }

    public final void b(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.g;
        }
        if (!this.f && this.g == j && this.h == z && this.i == z2) {
            return;
        }
        this.g = j;
        this.h = z;
        this.i = z2;
        this.f = false;
        c();
    }

    public final void h() {
    }

    public final void n(dw dwVar) {
        this.j = dwVar;
        this.d.o();
        nt ntVar = this.d;
        Looper myLooper = Looper.myLooper();
        af.s(myLooper);
        ntVar.q(myLooper, u());
        c();
    }

    public final void o(td tdVar) {
        ((tv) tdVar).I();
    }

    public final void p() {
        this.d.p();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.ads.interactivemedia.v3.internal.zn, java.lang.Object] */
    public final td q(te teVar, wr wrVar, long j) {
        de a = ((df) this.c).a();
        dw dwVar = this.j;
        if (dwVar != null) {
            a.f(dwVar);
        }
        Uri uri = this.b.a;
        xv xvVar = this.k;
        u();
        return new tv(uri, a, new sc(xvVar.a), this.d, v(teVar), this.l, x(teVar), this, wrVar, this.e, null, null, null);
    }
}
