package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class adq implements adr {
    private final List a;
    private final aae[] b;
    private boolean c;
    private int d;
    private int e;
    private long f = -9223372036854775807L;

    public adq(List list) {
        this.a = list;
        this.b = new aae[list.size()];
    }

    private final boolean f(cj cjVar, int i) {
        if (cjVar.a() == 0) {
            return false;
        }
        if (cjVar.i() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }

    public final void a(cj cjVar) {
        if (this.c) {
            if (this.d != 2 || f(cjVar, 32)) {
                if (this.d != 1 || f(cjVar, 0)) {
                    int c = cjVar.c();
                    int a = cjVar.a();
                    for (aae aaeVar : this.b) {
                        cjVar.F(c);
                        aaeVar.e(cjVar, a);
                    }
                    this.e += a;
                }
            }
        }
    }

    public final void b(zk zkVar, aet aetVar) {
        for (int i = 0; i < this.b.length; i++) {
            aeq aeqVar = (aeq) this.a.get(i);
            aetVar.c();
            aae i2 = zkVar.i(aetVar.a(), 3);
            r rVar = new r();
            rVar.S(aetVar.b());
            rVar.ae("application/dvbsubs");
            rVar.T(Collections.singletonList(aeqVar.b));
            rVar.V((String) aeqVar.a);
            i2.b(rVar.v());
            this.b[i] = i2;
        }
    }

    public final void c() {
        if (this.c) {
            if (this.f != -9223372036854775807L) {
                for (aae aaeVar : this.b) {
                    aaeVar.f(this.f, 1, this.e, 0, null);
                }
            }
            this.c = false;
        }
    }

    public final void d(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.f = j;
        }
        this.e = 0;
        this.d = 2;
    }

    public final void e() {
        this.c = false;
        this.f = -9223372036854775807L;
    }
}
