package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class lq implements aae {
    final /* synthetic */ lr a;
    private final ue b;
    private final go c = new go();
    private final ef e = new ef();
    private long d = -9223372036854775807L;

    public lq(lr lrVar, wr wrVar) {
        this.a = lrVar;
        this.b = ue.O(wrVar);
    }

    public final /* synthetic */ int a(k kVar, int i, boolean z) {
        return fz.h(this, kVar, i, z);
    }

    public final void b(s sVar) {
        this.b.b(sVar);
    }

    public final void c(uu uuVar) {
        long j = this.d;
        if (j == -9223372036854775807L || uuVar.m > j) {
            this.d = uuVar.m;
        }
        this.a.h();
    }

    public final void d() {
        this.b.A();
    }

    public final /* synthetic */ void e(cj cjVar, int i) {
        fz.i(this, cjVar, i);
    }

    public final void f(long j, int i, int i2, int i3, aad aadVar) {
        ef efVar;
        long j2;
        this.b.f(j, i, i2, i3, aadVar);
        while (this.b.K(false)) {
            this.e.b();
            if (this.b.o(this.c, this.e, 0, false) == -4) {
                this.e.j();
                efVar = this.e;
            } else {
                efVar = null;
            }
            if (efVar != null) {
                long j3 = efVar.d;
                ao a = lr.c(this.a).a(efVar);
                if (a != null) {
                    aal aalVar = (aal) a.b(0);
                    String str = aalVar.a;
                    String str2 = aalVar.b;
                    if ("urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2))) {
                        try {
                            j2 = cq.u(cq.I(aalVar.e));
                        } catch (as unused) {
                            j2 = -9223372036854775807L;
                        }
                        if (j2 != -9223372036854775807L) {
                            lo loVar = new lo(j3, j2);
                            lr lrVar = this.a;
                            lr.a(lrVar).sendMessage(lr.a(lrVar).obtainMessage(1, loVar));
                        }
                    }
                }
            }
        }
        this.b.v();
    }

    public final boolean g(uu uuVar) {
        long j = this.d;
        boolean z = false;
        if (j != -9223372036854775807L && j < uuVar.l) {
            z = true;
        }
        return this.a.g(z);
    }

    public final int h(k kVar, int i, boolean z) throws IOException {
        return fz.h(this.b, kVar, i, z);
    }

    public final void i(cj cjVar, int i) {
        fz.i(this.b, cjVar, i);
    }
}
