package com.google.ads.interactivemedia.v3.internal;

import android.os.Looper;
import java.io.IOException;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class pc extends sa implements qp {
    private final ox a;
    private final ad b;
    private final nt c;
    private final boolean d;
    private final int e;
    private final qq f;
    private final long g;
    private final ai h;
    private ac i;
    private dw j;
    private final oq k;
    private final ws l;
    private final ws m;

    static {
        aj.b("media3.exoplayer.hls");
    }

    public /* synthetic */ pc(ai aiVar, oq oqVar, ox oxVar, ws wsVar, nt ntVar, ws wsVar2, qq qqVar, long j, boolean z, int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        ad adVar = aiVar.b;
        af.s(adVar);
        this.b = adVar;
        this.h = aiVar;
        this.i = aiVar.c;
        this.k = oqVar;
        this.a = oxVar;
        this.m = wsVar;
        this.c = ntVar;
        this.l = wsVar2;
        this.f = qqVar;
        this.g = -9223372036854775807L;
        this.d = true;
        this.e = 1;
    }

    private static py c(List list, long j) {
        py pyVar = null;
        for (int i = 0; i < list.size(); i++) {
            py pyVar2 = (py) list.get(i);
            long j2 = pyVar2.g;
            if (j2 > j || !pyVar2.a) {
                if (j2 > j) {
                    break;
                }
            } else {
                pyVar = pyVar2;
            }
        }
        return pyVar;
    }

    private static qa d(List list, long j) {
        return (qa) list.get(cq.ap(list, Long.valueOf(j), true));
    }

    public final ai a() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011e A[PHI: r3
      0x011e: PHI (r3v18 com.google.ads.interactivemedia.v3.internal.py) = (r3v24 com.google.ads.interactivemedia.v3.internal.py), (r3v25 com.google.ads.interactivemedia.v3.internal.py) binds: [B:51:0x011c, B:57:0x0138] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0199  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(com.google.ads.interactivemedia.v3.internal.qd r32) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.pc.b(com.google.ads.interactivemedia.v3.internal.qd):void");
    }

    public final void h() throws IOException {
        this.f.s();
    }

    public final void n(dw dwVar) {
        this.j = dwVar;
        this.c.o();
        nt ntVar = this.c;
        Looper myLooper = Looper.myLooper();
        af.s(myLooper);
        ntVar.q(myLooper, u());
        this.f.v(this.b.a, x(null), this);
    }

    public final void o(td tdVar) {
        ((pa) tdVar).r();
    }

    public final void p() {
        this.f.w();
        this.c.p();
    }

    public final td q(te teVar, wr wrVar, long j) {
        tj x = x(teVar);
        return new pa(this.a, this.f, this.k, this.j, this.c, v(teVar), this.l, x, wrVar, this.m, true, 1, u(), null, null, null, null);
    }
}
